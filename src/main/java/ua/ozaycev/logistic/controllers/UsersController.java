package ua.ozaycev.logistic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.ozaycev.logistic.entity.Users;
import ua.ozaycev.logistic.services.UsersService;

/**
 * Created by Ozaycev on 31.05.2016.
 */
@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    private String newUser(Model model){
        model.addAttribute("users", new Users());
        return "registration";
    }

    @RequestMapping(value = "/createNewUser", method = RequestMethod.POST)
    private String createNewUser(@ModelAttribute Users users){
        usersService.add(users);
        return "redirect:/";
    }

    @RequestMapping(value = "/myCabinetUsers={id}", method = RequestMethod.GET)
    public String myCabinetUsers(@PathVariable String id, Model model){
        model.addAttribute("Main",usersService.findByID(Integer.parseInt(id)));
        return "user";
    }

}
