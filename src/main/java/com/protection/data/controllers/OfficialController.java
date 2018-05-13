package com.protection.data.controllers;

import com.protection.data.models.OfficialEntity;
import com.protection.data.models.OfficialhistoryEntity;
import com.protection.data.models.UsersEntity;
import com.protection.data.services.OfficialHistoryService;
import com.protection.data.services.OfficialService;
import com.protection.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class OfficialController {

    @Autowired
    UserService userService;

    @Autowired
    OfficialService officialService;

    @Autowired
    OfficialHistoryService officialhistoryService;


    @RequestMapping(value = "/seeOfficials", method = RequestMethod.GET)
    public ModelAndView getOfficials(Model model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        List<OfficialEntity> officials = officialService.findOfficials(user);
        modelAndView.addObject("officials", officials);
        modelAndView.setViewName("seeOfficials");
        return modelAndView;
    }

    @RequestMapping(value = "/{id1}/{id}/seeOfficials", method = RequestMethod.GET)
    public ModelAndView getOfficials2(Model model,@PathVariable String id) throws IOException {
        UsersEntity user = userService.findById(Integer.parseInt(id));
        ModelAndView modelAndView = new ModelAndView();
        List<OfficialEntity> officials = officialService.findOfficials(user);
        modelAndView.addObject("officials", officials);
        modelAndView.setViewName("seeOfficials");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/seeHistoryOfficials", method = RequestMethod.GET)
    public ModelAndView getHistoryOfficials(@PathVariable String id) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        OfficialEntity officialEntity = officialService.findById(Integer.parseInt(id));
        List<OfficialhistoryEntity> history = officialhistoryService.findOfficials(officialEntity);
        modelAndView.addObject("officials", history);
        modelAndView.setViewName("/seeHistoryOfficials");
        return modelAndView;
    }



    @RequestMapping(value = "/{id1}/{id2}/{id}/seeHistoryOfficials", method = RequestMethod.GET)
    public ModelAndView getHistoryOfficials2(@PathVariable String id) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        OfficialEntity officialEntity = officialService.findById(Integer.parseInt(id));
        List<OfficialhistoryEntity> history = officialhistoryService.findOfficials(officialEntity);
        modelAndView.addObject("officials", history);
        modelAndView.setViewName("/seeHistoryOfficials");
        return modelAndView;
    }

    @RequestMapping(value = "/addOfficials", method = RequestMethod.GET)
    public String getSongs(Model model) {
        OfficialEntity official = new OfficialEntity();
        model.addAttribute("official", official);
        return "addOfficials";
    }

    @RequestMapping(value = "/addOfficials", method = RequestMethod.POST)
    public String saveOfficials(@ModelAttribute("official") OfficialEntity official, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        official.setUser(user);
        officialService.saveOfficial(official);
        OfficialEntity official2 = new OfficialEntity();
        OfficialhistoryEntity officialhistory = new OfficialhistoryEntity();
        int max = officialService.findMaxOfficial();
        OfficialEntity newOfficial = officialService.findById(max);
        officialhistoryService.saveOfficial(newOfficial,officialhistory);
        model.addAttribute("official", official2);
        model.addAttribute("successMessage", "Добавление прошло успешно");
        return "addOfficials";
    }


    @RequestMapping(value = "/{id}/editOfficials", method = RequestMethod.GET)
    public ModelAndView addOfficials(@PathVariable String id) {
        OfficialEntity official = officialService.findById(Integer.parseInt(id));
        ModelAndView model = new ModelAndView();
        model.addObject("official", official);
        model.setViewName("editOfficials");
        return model;
    }

    @RequestMapping(value = "/{id1}/{id2}/{id}/editOfficials", method = RequestMethod.GET)
    public ModelAndView addOfficials2(@PathVariable String id) {
        OfficialEntity official = officialService.findById(Integer.parseInt(id));
        ModelAndView model = new ModelAndView();
        model.addObject("official", official);
        model.setViewName("editOfficials");
        return model;
    }

    @RequestMapping(value = "/editOfficials", method = RequestMethod.POST)
    public String editOfficial(@ModelAttribute("official") OfficialEntity official, Model model) {
        UsersEntity user = userService.FindByLogin(official.getUser().getLogin());
        official.setUser(user);
        officialService.saveOfficial(official);
        OfficialhistoryEntity officialhistory = new OfficialhistoryEntity();
        officialhistoryService.saveOfficial(official,officialhistory);
        return "redirect:" + user.getIdUser()+"/"+ user.getIdUser()+ "/seeOfficials";
    }

    @RequestMapping(value = "/{id}/deleteOfficials", method = RequestMethod.GET)
    public ModelAndView deleteOfficial(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        officialService.deleteUser(id);
        model.setViewName("delete");
        return model;
    }

    @RequestMapping(value = "/{id2}/{id1}/{id}/deleteOfficials", method = RequestMethod.GET)
    public ModelAndView deleteOfficial2(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        officialService.deleteUser(id);
        model.setViewName("delete");
        return model;
    }

}