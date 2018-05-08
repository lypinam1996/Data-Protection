package com.protection.data.controllers;

import com.protection.data.models.OfficialEntity;
import com.protection.data.models.UsersEntity;
import com.protection.data.services.OfficialService;
import com.protection.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    OfficialService officialService;

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
            List<OfficialEntity> officials = officialService.findAllOfficials();
            int count = officials.size();
            modelAndView.addObject("count", count);
            modelAndView.setViewName("mainPage");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/seeOfficials", method = RequestMethod.GET)
    public ModelAndView getOfficials(Model model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        System.out.println(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        List<OfficialEntity> officials = officialService.findOfficials(user);
        modelAndView.addObject("officials", officials);
        modelAndView.setViewName("seeOfficials");
        return modelAndView;
    }

    @RequestMapping(value = "/addOfficials", method = RequestMethod.GET)
    public String getSongs(Model model){
        OfficialEntity official = new OfficialEntity();
        model.addAttribute("official",official);
        return "addOfficials";
    }

    @RequestMapping(value = "/addOfficials", method = RequestMethod.POST)
    public String saveLock(@ModelAttribute("official") OfficialEntity official, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        official.setUser(user);
        officialService.saveOfficial(official);
        OfficialEntity official2 = new OfficialEntity();
        model.addAttribute("official",official2);
        return "addOfficials";
    }


    @RequestMapping(value = "/{id}/editOfficials", method = RequestMethod.GET)
    public ModelAndView addLock(@PathVariable String id){
        OfficialEntity official = officialService.findById(Integer.parseInt(id));
        ModelAndView model = new ModelAndView();
        model.addObject("official",official);
        model.setViewName("editOfficials");
        return model;
    }

    @RequestMapping(value = "/{id}/editOfficials", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("official") OfficialEntity officialEntity,
                           BindingResult bindingResult,
                           Model model,
                           @RequestParam(value = "id", required = true) Integer id) {
        officialService.saveOfficial(officialEntity);
        return "editOfficials";
    }
}
