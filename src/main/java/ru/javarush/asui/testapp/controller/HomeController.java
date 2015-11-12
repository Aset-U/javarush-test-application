package ru.javarush.asui.testapp.controller;

import ru.javarush.asui.testapp.model.Admin;
import ru.javarush.asui.testapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired(required = true)
    private AdminService adminService;
    @RequestMapping(value = {"","/index"}, method = RequestMethod.GET)
    public String viewLogin(Model model) {
        model.addAttribute("admin", new Admin());
        return "/index";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String userCRUD() {
        return "/cart";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String todoList() {
        return "/orders";
    }
}
