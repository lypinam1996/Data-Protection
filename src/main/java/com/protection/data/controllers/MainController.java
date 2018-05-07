package com.protection.data.controllers;

import com.protection.data.models.UsersEntity;
import com.protection.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
@Controller
public class MainController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getTasks(Model model) throws IOException {
       // Exel exel = new Exel();
        //exel.writeIntoExcel("a.ods");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        if (user.getStatus().getTitle().equals("ADMIN")){
            modelAndView.setViewName("adminMainPage");
        }
        else{
            modelAndView.setViewName("mainPage");
        }
        return modelAndView;
    }
}
