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



    @RequestMapping(value = "/{id1}/{id}/seePersonals", method = RequestMethod.GET)
    public ModelAndView getAllPersonals2(Model model,@PathVariable String id) throws IOException {
        UsersEntity user = userService.findById(Integer.parseInt(id));
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

    @RequestMapping(value = "/{id1}/{id2}/{id}/seeHistoryPersonals", method = RequestMethod.GET)
    public ModelAndView getHistoryPersonals2(@PathVariable String id) throws IOException {
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


    @RequestMapping(value = "/{id}/editPersonal", method = RequestMethod.GET)
    public String addPersonals(@PathVariable String id, Model model) {
        List<PersonaldataEntity>  data= personalDataService.findAll();
        List<CategoryofsubjectEntity>  category= categoryOfSubjectService.findAll();
        List<YesnoEntity>  yesno= yesNoService.findAll();
        List<CountsubjectsEntity>  coount= countSubjectsService.findAll();
        List<TypethreatEntity>  types= typeThreatService.findAll();
        List<SecuritylevelEntity>  level= securityLevelService.findAll();
        model.addAttribute("data", data);
        model.addAttribute("category", category);
        model.addAttribute("yesno", yesno);
        model.addAttribute("coount", coount);
        model.addAttribute("types", types);
        model.addAttribute("level", level);
        PersonalinformationsystemEntity personal = personalService.findById(Integer.parseInt(id));

        model.addAttribute("personal", personal);
        return "editPersonal";
    }

    @RequestMapping(value = "/{id2}/{id1}/{id}/editPersonal", method = RequestMethod.GET)
    public String addPersonals2(@PathVariable String id, Model model) {
        List<PersonaldataEntity>  data= personalDataService.findAll();
        List<CategoryofsubjectEntity>  category= categoryOfSubjectService.findAll();
        List<YesnoEntity>  yesno= yesNoService.findAll();
        List<CountsubjectsEntity>  coount= countSubjectsService.findAll();
        List<TypethreatEntity>  types= typeThreatService.findAll();
        List<SecuritylevelEntity>  level= securityLevelService.findAll();
        model.addAttribute("data", data);
        model.addAttribute("category", category);
        model.addAttribute("yesno", yesno);
        model.addAttribute("coount", coount);
        model.addAttribute("types", types);
        model.addAttribute("level", level);
        PersonalinformationsystemEntity personal = personalService.findById(Integer.parseInt(id));

        model.addAttribute("personal", personal);
        return "editPersonal";
    }

    @RequestMapping(value = "/editPersonal", method = RequestMethod.POST)
    public String editPersonals(@ModelAttribute("personal") PersonalinformationsystemEntity personal, Model model) {
        UsersEntity user = userService.FindByLogin(personal.getUser().getLogin());
        personal.setUser(user);
        personalService.savePersonal(personal);
        PersonalinformationsystemhistoryEntity history = new PersonalinformationsystemhistoryEntity();
        personalInformationSystemHistoryService.saveHistory(personal,history);
        return "redirect:" + user.getIdUser()+"/"+ user.getIdUser()+ "/seePersonals";
    }

    @RequestMapping(value = "/{id}/deletePersonal", method = RequestMethod.GET)
    public ModelAndView deletePersonals(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        personalService.deletePersonal(id);
        model.setViewName("delete");
        return model;
    }

    @RequestMapping(value = "/{id2}/{id3}/{id}/deletePersonal", method = RequestMethod.GET)
    public ModelAndView deletePersonals2(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        personalService.deletePersonal(id);
        model.setViewName("delete");
        return model;
    }


}