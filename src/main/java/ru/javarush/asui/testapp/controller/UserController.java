package ru.javarush.asui.testapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.javarush.asui.testapp.model.User;
import ru.javarush.asui.testapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user-crud")
    public String getUsers(Model model, Integer offset, Integer maxResults) {
        model.addAttribute("users", userService.getPageList(offset, maxResults));
        model.addAttribute("count", userService.count());
        model.addAttribute("offset", offset);
        return "/user-crud";
    }


    @RequestMapping(value = {"/addUser"}, method = RequestMethod.GET)
    public String addUser(Model model) {
         model.addAttribute("user", new User());
        return "/add_user";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("user") User user,
                             BindingResult result, HttpServletRequest request) {

        System.out.println(user);
        System.out.println(request.getParameter("isAdmin"));

        return "redirect:/user-crud";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value="userDeleted", required=true) Integer id,
                         Model model) {

        return "redirect:/user-crud";
    }

    @RequestMapping(value = "/user-crud/search", method = RequestMethod.POST)
    public String searchUser(Model model, HttpServletRequest request) {
        List<User> users = null;
        String result = request.getParameter("search");

        if (result.isEmpty()){
            return "redirect:/user-crud";
        }
        else {
            users = userService.getByName(result);

            if (users.size() != 0) {
                model.addAttribute("searchUsers", users);
                return "/user-search";
            }
            else {
                request.setAttribute("notResult", "Not found on users");
                return "/user-search";
            }
        }

    }
}
