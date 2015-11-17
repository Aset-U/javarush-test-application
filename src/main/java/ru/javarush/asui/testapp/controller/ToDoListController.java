package ru.javarush.asui.testapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.javarush.asui.testapp.model.Status;
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
}
