package ru.javarush.asui.testapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javarush.asui.testapp.model.User;
import ru.javarush.asui.testapp.service.UserService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired(required = true)
    private UserService userService;
    @RequestMapping(value = {"","/index"}, method = RequestMethod.GET)
    public String viewLogin() {
        return "/index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<User> userList = userService.getAll();
        model.addAttribute("users", userList);
        return "users";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String todoList() {
        return "to-do-list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value="userDeleted", required=true) Integer id,
                         Model model) {
        List<User> userList = userService.getAll();
        model.addAttribute("user", userList);
        System.out.println(id);
        return "user";
    }
}
