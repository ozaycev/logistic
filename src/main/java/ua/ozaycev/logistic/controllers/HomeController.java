package ua.ozaycev.logistic.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.ozaycev.logistic.services.UsersService;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpSession httpSession, Principal principal)
    {
//        if (principal==null) {
//            return "redirect:/home";
//        } else {
//            httpSession.setAttribute("loginedUser", usersService.findByID(Integer.parseInt(principal.getName())));
//            return "home";
//        }
        return "home";
    }

}
