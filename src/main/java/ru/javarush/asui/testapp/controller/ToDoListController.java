package ru.javarush.asui.testapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javarush.asui.testapp.model.Category;
import ru.javarush.asui.testapp.model.Status;
import ru.javarush.asui.testapp.model.ToDoItem;
import ru.javarush.asui.testapp.service.CategoryService;
import ru.javarush.asui.testapp.service.CategoryServiceImpl;
import ru.javarush.asui.testapp.service.ToDoItemService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ToDoListController {

    @Autowired
    ToDoItemService toDoItemService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String todoList(Model model, Integer offset, Integer maxResults) {
        model.addAttribute("todoList", toDoItemService.getPageList(offset, maxResults));
        model.addAttribute("count", toDoItemService.count());
        model.addAttribute("offset", offset);
        return "/todo-list";
    }

    @RequestMapping(value = "/list/performedList", method = RequestMethod.GET)
    public String performedList(Model model, Integer offset, Integer maxResults) {
        model.addAttribute("performedList", toDoItemService.findByStatus(Status.PERFORMED ,offset, maxResults));
        model.addAttribute("count", toDoItemService.count());
        model.addAttribute("offset", offset);
        return "/performed-list";
    }

    @RequestMapping(value = "/list/notDoneList", method = RequestMethod.GET)
    public String notDoneList(Model model, Integer offset, Integer maxResults) {
        model.addAttribute("notDoneList", toDoItemService.findByStatus(Status.NOT_DONE, offset, maxResults));
        model.addAttribute("count", toDoItemService.count());
        model.addAttribute("offset", offset);
        return "/not-done-list";
    }

    @RequestMapping(value = {"/addItem"}, method = RequestMethod.GET)
    public String addItemForm(Model model) {
        model.addAttribute("todoItem", new ToDoItem());
        model.addAttribute("categories", categoryService.getAll());
        return "/add-todo-item";
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("todoItem") ToDoItem todoItem,
                          BindingResult result, HttpServletRequest request) {

        Category category = categoryService.get(Integer.parseInt(request.getParameter("category")));
        todoItem.setCategory(category);
        toDoItemService.add(todoItem);

        return "redirect:/list";
    }

    @RequestMapping(value = {"/list/edit"}, method = RequestMethod.GET)
    public String editItemForm(@RequestParam(value="itemId", required=true) Integer id, Model model) {
        ToDoItem toDoItem = toDoItemService.get(id);
        model.addAttribute("itemEdit", toDoItem);
        model.addAttribute("categories", categoryService.getAll());
        return "/edit-todo-item";
    }

    @RequestMapping(value = "/editItem", method = RequestMethod.POST)
    public String editItem(@ModelAttribute("itemEdit") ToDoItem toDoItem,
                           BindingResult result, HttpServletRequest request) {

        toDoItem.setId(Integer.parseInt(request.getParameter("OldItemId")));
        toDoItem.setCategory(categoryService.get(Integer.parseInt(request.getParameter("category"))));
        toDoItemService.update(toDoItem);
        return "redirect:/list";
    }

    @RequestMapping(value = "/list/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="itemId", required=true) Integer id,
                         Model model) {

       ToDoItem userDeleted = toDoItemService.get(id);
       toDoItemService.delete(userDeleted);
        return "redirect:/list";
    }
}
