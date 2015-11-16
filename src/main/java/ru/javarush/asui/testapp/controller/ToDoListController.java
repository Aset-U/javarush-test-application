package ru.javarush.asui.testapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.javarush.asui.testapp.service.ToDoItemService;

@Controller
public class ToDoListController {

    @Autowired
    ToDoItemService toDoItemService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String todoList(Model model, Integer offset, Integer maxResults) {
        model.addAttribute("todoList", toDoItemService.getPageList(offset, maxResults));
        model.addAttribute("count", toDoItemService.count());
        model.addAttribute("offset", offset);
        return "/todo-list";
    }
}
