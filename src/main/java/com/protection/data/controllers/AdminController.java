package com.protection.data.controllers;

import com.protection.data.models.*;
import com.protection.data.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AuthorityService authority;

    @Autowired
    UserService users;

    @Autowired
    OfficialService officialService;

    @Autowired
    QuantityService quantityService;

    @Autowired
    StateInformationService stateInformationService;
    @Autowired
    FinancinService financinService;
    @Autowired
    PersonalService personalService;

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

    @RequestMapping(value="/{id}/users", method = RequestMethod.GET)
    public ModelAndView user(Model model, @PathVariable int id) {
        AuthoritiesEntity authorities = authority.findById(id);
        List<UsersEntity> user1 = users.findByAuth(authorities);
        ModelAndView modelAndView = new ModelAndView();
        if(!user1.isEmpty()) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            user1.remove(users.FindByLogin(auth.getName()));
            modelAndView.addObject("user1", user1.get(0));
            modelAndView.addObject("users", user1);
        }
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @RequestMapping(value="/authorities", method = RequestMethod.GET)
    public ModelAndView authorities() {
        List<AuthoritiesEntity> authorities = authority.findAllAuthorities();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("authorities", authorities);
        modelAndView.setViewName("authorities");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/tables", method = RequestMethod.GET)
    public ModelAndView getTables(Model model, @PathVariable int id) throws IOException {
        AuthoritiesEntity authorities= authority.findById(id);
        List<UsersEntity> user1 = users.findByAuth(authorities);
        UsersEntity user = user1.get(0);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", user);
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
        modelAndView.addObject("count3", count3);
        modelAndView.addObject("count4", count4);
        modelAndView.addObject("count5", count5);
        modelAndView.setViewName("tables");
        return modelAndView;
    }

    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public ModelAndView getTasks() throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        List<OfficialEntity> officials = officialService.findAllOfficials();
        int count = officials.size();
        modelAndView.addObject("count", count);
        List<QuantityEntity> quantity = quantityService.findAllQuantities();
        int count2 = quantity.size();
        modelAndView.addObject("count2", count2);
        List<StateinformationsystemEntity> states   = stateInformationService.findAllStateInformation();
        int count3 = states.size();
        List<PersonalinformationsystemEntity> personal   = personalService.findAllPersonal();
        int count4 = personal.size();
        List<FinancingEntity> financing   = financinService.findAllFinancing();
        int count5 = financing.size();
        modelAndView.addObject("count3", count3);
        modelAndView.addObject("count4", count4);
        modelAndView.addObject("count5", count5);
        modelAndView.setViewName("table");
        return modelAndView;
    }

    @RequestMapping(value = "/{id1}/{id}/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteFinancing(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        users.deleteUser(id);
        model.setViewName("successDeleting");
        return model;
    }
}
