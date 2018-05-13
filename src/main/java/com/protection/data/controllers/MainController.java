package com.protection.data.controllers;

import com.protection.data.models.*;
import com.protection.data.services.*;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    OfficialService officialService;

    @Autowired
    AuthorityService authoritiesService;

    @Autowired
    QuantityService quantityService;

    @Autowired
    StateInformationService stateInformationService;

    @Autowired
    PersonalService personalService;
    @Autowired
    FinancinService financinService;

    @Autowired
    OfficialHistoryService officialhistoryService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getTasks(Model model) throws IOException {
        // Exel exel = new Exel();
        //exel.writeIntoExcel("a.ods");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        if (user.getStatus().getTitle().equals("ADMIN")) {
            modelAndView.setViewName("adminMainPage");
        } else {
            List<OfficialEntity> officials = officialService.findOfficials(user);
            int count = officials.size();
            modelAndView.addObject("count", count);
            List<QuantityEntity> quantity = quantityService.findQuantities(user);
            int count2 = quantity.size();
            modelAndView.addObject("count2", count2);
            List<StateinformationsystemEntity> states   = stateInformationService.findStateInformation(user);
            int count3 = states.size();
            List<PersonalinformationsystemEntity> personal   = personalService.findPersonal(user);
            int count4 = personal.size();
            List<FinancingEntity> financing   = financinService.findFinancing(user);
            int count5 = financing.size();
             modelAndView.addObject("states", states);
            modelAndView.addObject("count3", count3);
            modelAndView.addObject("count4", count4);
            modelAndView.addObject("count5", count5);
            modelAndView.setViewName("mainPage");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public ModelAndView getTasks() throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        int count = 1;
        modelAndView.addObject("count1", count);
        modelAndView.addObject("count2", count);
        modelAndView.addObject("count3", count);
        modelAndView.addObject("count4", count);
        modelAndView.addObject("count5", count);
        modelAndView.setViewName("table");
        return modelAndView;
    }

   @RequestMapping(value = "/seeUser", method = RequestMethod.GET)
    public ModelAndView getOfficials(Model model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        List<UsersEntity> users = new ArrayList<>();
        users.add(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("seeUser");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/editUser", method = RequestMethod.GET)
    public ModelAndView addOfficials(@PathVariable String id) {
        UsersEntity usersEntity = userService.findById(Integer.parseInt(id));
        List<SubjectrfEntity> subjects = subjectService.findAllSubjects();
        List<AuthoritiesEntity> authorities = authoritiesService.findAllAuthorities();

        ModelAndView model = new ModelAndView();
        model.addObject("authorities", authorities);
        model.addObject("subjects", subjects);
        model.addObject("user", usersEntity);
        model.setViewName("editUser");
        return model;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editOfficial(@ModelAttribute("user") UsersEntity user, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user2 = userService.FindByLogin(auth.getName());
        user.setStatus(user2.getStatus());
        userService.updateUser(user);
        return "redirect:" + "/home";
    }

}
