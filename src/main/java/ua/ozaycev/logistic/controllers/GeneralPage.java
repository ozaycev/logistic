package ua.ozaycev.logistic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ozaycev on 31.05.2016.
 */
@Controller
public class GeneralPage {
    @RequestMapping(value = "/general", method = RequestMethod.GET)
    public String generalPage() {
        return "general";
    }
}
