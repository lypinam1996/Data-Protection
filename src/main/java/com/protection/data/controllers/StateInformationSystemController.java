package com.protection.data.controllers;

import com.protection.data.models.StateinformationsystehistoryEntity;
import com.protection.data.models.StateinformationsystemEntity;
import com.protection.data.models.TypeofcryptoprotectionEntity;
import com.protection.data.models.UsersEntity;
import com.protection.data.services.CryptoProtectionService;
import com.protection.data.services.StateInformationHistoryService;
import com.protection.data.services.StateInformationService;
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
public class StateInformationSystemController {

    @Autowired
    UserService userService;

    @Autowired
    StateInformationService stateInformationService;

    @Autowired
    StateInformationHistoryService stateInformationHistoryService;
    @Autowired
    CryptoProtectionService cryptoProtectionService;


    @RequestMapping(value = "/seeStates", method = RequestMethod.GET)
    public ModelAndView getStates(Model model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        List<StateinformationsystemEntity> states = stateInformationService.findStateInformation(user);
        modelAndView.addObject("states", states);
        modelAndView.setViewName("seeStates");
        return modelAndView;
    }

    @RequestMapping(value = "/{id1}/{id}/seeStates", method = RequestMethod.GET)
    public ModelAndView getStates2(Model model,@PathVariable String id) throws IOException {
        UsersEntity user = userService.findById(Integer.parseInt(id));
        ModelAndView modelAndView = new ModelAndView();
        List<StateinformationsystemEntity> states = stateInformationService.findStateInformation(user);
        modelAndView.addObject("states", states);
        modelAndView.setViewName("seeStates");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/seeHistiryStates", method = RequestMethod.GET)
    public ModelAndView getHistoryStates(@PathVariable String id) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        StateinformationsystemEntity stateinformationsystemEntity = stateInformationService.findById(Integer.parseInt(id));
        List<StateinformationsystehistoryEntity> history = stateInformationHistoryService.findStateInformationHistories(stateinformationsystemEntity);
        modelAndView.addObject("states", history);
        modelAndView.setViewName("seeHistoryStates");
        return modelAndView;
    }

    @RequestMapping(value = "/{id1}/{id2}/{id}/seeHistiryStates", method = RequestMethod.GET)
    public ModelAndView getHistoryStates2(@PathVariable String id) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        StateinformationsystemEntity stateinformationsystemEntity = stateInformationService.findById(Integer.parseInt(id));
        List<StateinformationsystehistoryEntity> history = stateInformationHistoryService.findStateInformationHistories(stateinformationsystemEntity);
        modelAndView.addObject("states", history);
        modelAndView.setViewName("seeHistoryStates");
        return modelAndView;
    }


    @RequestMapping(value = "/addStates", method = RequestMethod.GET)
    public String getSongs(Model model) {
        List<TypeofcryptoprotectionEntity> typeofcryptoprotectionEntities = cryptoProtectionService.findAllSubjects();
        StateinformationsystemEntity stateinformationsystemEntity = new StateinformationsystemEntity();
        model.addAttribute("types", typeofcryptoprotectionEntities);
        model.addAttribute("state", stateinformationsystemEntity);
        return "addStates";
    }

    @RequestMapping(value = "/addStates", method = RequestMethod.POST)
    public String saveOfficials(@ModelAttribute("state") StateinformationsystemEntity stateinformationsystemEntity, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        stateinformationsystemEntity.setUser(user);
        stateInformationService.saveStateInformation(stateinformationsystemEntity);

        StateinformationsystemEntity stateinformationsystemEntity1 = new StateinformationsystemEntity();
        StateinformationsystehistoryEntity stateHistory= new StateinformationsystehistoryEntity();
        int max = stateInformationService.findMaxOfficial();
        StateinformationsystemEntity newOfficial = stateInformationService.findById(max);
        stateInformationHistoryService.saveStateInformationHistory(newOfficial,stateHistory);
        model.addAttribute("state", stateinformationsystemEntity1);
        model.addAttribute("successMessage", "Добавление прошло успешно");
        return "addStates";
    }


    @RequestMapping(value = "/{id}/editStates", method = RequestMethod.GET)
    public ModelAndView addStates(@PathVariable String id) {
        StateinformationsystemEntity state = stateInformationService.findById(Integer.parseInt(id));
        ModelAndView model = new ModelAndView();
        model.addObject("state", state);
        model.setViewName("editStates");
        return model;
    }

    @RequestMapping(value = "/{id1}/{id2}/{id}/editStates", method = RequestMethod.GET)
    public ModelAndView addStates2(@PathVariable String id) {
        StateinformationsystemEntity state = stateInformationService.findById(Integer.parseInt(id));
        ModelAndView model = new ModelAndView();
        model.addObject("state", state);
        model.setViewName("editStates");
        return model;
    }

    @RequestMapping(value = "/editStates", method = RequestMethod.POST)
    public String editOfficial(@ModelAttribute("state") StateinformationsystemEntity statesEnt, Model model) {
        UsersEntity user = userService.FindByLogin(statesEnt.getUser().getLogin());
        statesEnt.setUser(user);
        stateInformationService.saveStateInformation(statesEnt);
        StateinformationsystehistoryEntity history = new StateinformationsystehistoryEntity();
        stateInformationHistoryService.saveStateInformationHistory(statesEnt,history);
        return "redirect:" + user.getIdUser()+"/"+ user.getIdUser()+ "/seeStates";
    }

    @RequestMapping(value = "/{id}/deleteStates", method = RequestMethod.GET)
    public ModelAndView deleteState(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        stateInformationService.deleteUser(id);
        model.setViewName("delete");
        return model;
    }
    @RequestMapping(value = "/{id3}/{id2}/{id}/deleteStates", method = RequestMethod.GET)
    public ModelAndView deleteState2(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        stateInformationService.deleteUser(id);
        model.setViewName("delete");
        return model;
    }

}