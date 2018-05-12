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
import java.util.List;

@Controller
public class PersonalController {

    @Autowired
    UserService userService;

    @Autowired
    PersonalService personalService;

    @Autowired
    PersonalInformationSystemHistoryService personalInformationSystemHistoryService;
    @Autowired
    CryptoProtectionService cryptoProtectionService;
    @Autowired
    PersonalDataService personalDataService;
    @Autowired
    CategoryOfSubjectService categoryOfSubjectService;
    @Autowired
    YesNoService yesNoService;
    @Autowired
    CountSubjectsService countSubjectsService;
    @Autowired
    TypeThreatService typeThreatService;
    @Autowired
    SecurityLevelService securityLevelService;

    @RequestMapping(value = "/seePersonals", method = RequestMethod.GET)
    public ModelAndView getAllPersonals(Model model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        List<PersonalinformationsystemEntity> personal = personalService.findPersonal(user);
        modelAndView.addObject("personals", personal);
        modelAndView.setViewName("seePersonals");
        return modelAndView;
    }

   @RequestMapping(value = "/{id}/seeHistoryPersonals", method = RequestMethod.GET)
    public ModelAndView getHistoryPersonals(@PathVariable String id) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        PersonalinformationsystemEntity personal = personalService.findById(Integer.parseInt(id));
        List<PersonalinformationsystemhistoryEntity> history = personalInformationSystemHistoryService.findPersonalInformationSystemHistories(personal);
        modelAndView.addObject("personals", history);
        modelAndView.setViewName("seeHistoryPersonals");
        return modelAndView;
    }


   @RequestMapping(value = "/addPersonal", method = RequestMethod.GET)
    public String getPersonals(Model model) {
        List<PersonaldataEntity>  data= personalDataService.findAll();
       List<CategoryofsubjectEntity>  category= categoryOfSubjectService.findAll();
       List<YesnoEntity>  yesno= yesNoService.findAll();
       List<CountsubjectsEntity>  coount= countSubjectsService.findAll();
       List<TypethreatEntity>  types= typeThreatService.findAll();
       List<SecuritylevelEntity>  level= securityLevelService.findAll();
       PersonalinformationsystemEntity personal = new PersonalinformationsystemEntity();
        model.addAttribute("data", data);
       model.addAttribute("category", category);
       model.addAttribute("yesno", yesno);
       model.addAttribute("coount", coount);
       model.addAttribute("types", types);
       model.addAttribute("level", level);
        model.addAttribute("personal", personal);
        return "addPersonal";
    }

    @RequestMapping(value = "/addPersonal", method = RequestMethod.POST)
    public String savePersonals(@ModelAttribute("personal") PersonalinformationsystemEntity personal, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        personal.setUser(user);
        personalService.savePersonal(personal);

        PersonalinformationsystemEntity personal1 = new PersonalinformationsystemEntity();
        PersonalinformationsystemhistoryEntity history= new PersonalinformationsystemhistoryEntity();
        int max = personalService.findMaxPersonal();
        PersonalinformationsystemEntity newPers = personalService.findById(max);
        personalInformationSystemHistoryService.saveHistory(newPers,history);
        model.addAttribute("personal", personal1);
        model.addAttribute("successMessage", "Добавление прошло успешно");
        return "addPersonal";
    }


   /* @RequestMapping(value = "/{id}/editStates", method = RequestMethod.GET)
    public ModelAndView addPersonals(@PathVariable String id) {
        StateinformationsystemEntity state = stateInformationService.findById(Integer.parseInt(id));
        ModelAndView model = new ModelAndView();
        model.addObject("state", state);
        model.setViewName("editStates");
        return model;
    }

    @RequestMapping(value = "/editStates", method = RequestMethod.POST)
    public String editPersonals(@ModelAttribute("state") StateinformationsystemEntity statesEnt, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        statesEnt.setUser(user);
        stateInformationService.saveStateInformation(statesEnt);
        StateinformationsystehistoryEntity history = new StateinformationsystehistoryEntity();
        stateInformationHistoryService.saveStateInformationHistory(statesEnt,history);
        return "redirect:" + "/seeStates";
    }

    @RequestMapping(value = "/{id}/deleteStates", method = RequestMethod.GET)
    public ModelAndView deletePersonals(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        stateInformationService.deleteUser(id);
        model.setViewName("delete");
        return model;
    }*/

}