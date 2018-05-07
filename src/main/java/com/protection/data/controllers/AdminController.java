package com.protection.data.controllers;

import com.protection.data.models.UsersEntity;
import com.protection.data.services.AuthorityService;
import com.protection.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AuthorityService authority;

    @Autowired
    UserService users;

    @RequestMapping(value = "/mainAdmin", method = RequestMethod.GET)
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminMainPage");
        return modelAndView;
    }

    @RequestMapping(value="/request", method = RequestMethod.GET)
    public ModelAndView registration(){
        List<UsersEntity> usersRequests = users.findAllUsersWhereControlEquals1();
        int count = usersRequests.size();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", usersRequests);
        modelAndView.addObject("count", count);
        modelAndView.setViewName("request");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/confirm", method = RequestMethod.GET)
    public ModelAndView confirmRegistration(@PathVariable int id){
        UsersEntity user = users.findById(id);
        ModelAndView model = new ModelAndView();
        users.confirmRegistration(user);
        model.setViewName("confirm");
        return model;
    }

    @RequestMapping(value = "/{id}/reject", method = RequestMethod.GET)
    public ModelAndView rejectRequest(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        users.deleteUser(id);
        model.setViewName("reject");
        return model;
    }
}
