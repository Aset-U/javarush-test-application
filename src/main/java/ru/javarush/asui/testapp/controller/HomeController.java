package ru.javarush.asui.testapp.controller;

import com.sun.deploy.net.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javarush.asui.testapp.model.User;
import ru.javarush.asui.testapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {


    @RequestMapping(value = {"","/index"}, method = RequestMethod.GET)
    public String viewLogin() {
        return "/index";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String todoList() {
        return "to-do-list";
    }


}
