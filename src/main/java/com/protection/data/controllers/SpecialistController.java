package com.protection.data.controllers;

import com.protection.data.models.QuantityEntity;
import com.protection.data.models.SpecialistsEntity;
import com.protection.data.models.SpecialistshistoryEntity;
import com.protection.data.models.UsersEntity;
import com.protection.data.services.QuantityService;
import com.protection.data.services.SpecialistHistotyService;
import com.protection.data.services.SpecialistService;
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
public class SpecialistController {

    @Autowired
    UserService userService;

    @Autowired
    SpecialistService specialistService;

    @Autowired
    QuantityService quantityService;

    @Autowired
    SpecialistHistotyService specialistHistotyService;


     @RequestMapping(value = "/{id}/seeSpecialist", method = RequestMethod.GET)
    public ModelAndView getQuantities(@PathVariable String id) {
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         UsersEntity user = userService.FindByLogin(auth.getName());
        QuantityEntity quantity = quantityService.findById(Integer.parseInt(id));
         List<SpecialistsEntity> specialists = specialistService.findSpecialist(user,quantity);
        ModelAndView model = new ModelAndView();
        model.addObject("specialists", specialists);
        model.setViewName("seeSpecialist");
        return model;
    }

    @RequestMapping(value = "/{id3}/{id2}/{id1}/{id}/seeSpecialist", method = RequestMethod.GET)
    public ModelAndView getQuantities2(@PathVariable String id, @PathVariable String id1) {
        UsersEntity user = userService.findById(Integer.parseInt(id1));
        QuantityEntity quantity = quantityService.findById(Integer.parseInt(id));
        List<SpecialistsEntity> specialists = specialistService.findSpecialist(user,quantity);
        ModelAndView model = new ModelAndView();
        model.addObject("specialists", specialists);
        model.setViewName("seeSpecialist");
        return model;
    }


    @RequestMapping(value = "/{id1}/{id}/seeHistirySpecialist", method = RequestMethod.GET)
    public ModelAndView getHistirySpecialist(@PathVariable String id) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        SpecialistsEntity specialistsEntity = specialistService.findById(Integer.parseInt(id));
        List<SpecialistshistoryEntity> history = specialistHistotyService.findSpecialist2(user,specialistsEntity);
        modelAndView.addObject("specialists", history);
        modelAndView.setViewName("seeHistirySpecialist");
        return modelAndView;
    }

    @RequestMapping(value = "/{id2}/{id3}/{id4}/{id1}/{id}/seeHistirySpecialist", method = RequestMethod.GET)
    public ModelAndView getHistirySpecialist2(@PathVariable String id,@PathVariable String id1,@PathVariable String id4) throws IOException {
        UsersEntity user = userService.findById(Integer.parseInt(id4));
        ModelAndView modelAndView = new ModelAndView();
        SpecialistsEntity specialistsEntity = specialistService.findById(Integer.parseInt(id));
        List<SpecialistshistoryEntity> history = specialistHistotyService.findSpecialist2(user,specialistsEntity);
        modelAndView.addObject("specialists", history);
        modelAndView.setViewName("seeHistirySpecialist");
        return modelAndView;
    }


    @RequestMapping(value = "/{id}/addSpecialist", method = RequestMethod.GET)
    public String getSpecialist(Model model,@PathVariable String id) {
        QuantityEntity quantity = quantityService.findById(Integer.parseInt(id));
        SpecialistsEntity specialist = new SpecialistsEntity();
        specialist.setQuantity(quantity);
        model.addAttribute("specialist", specialist);
        return "addSpecialist";
    }

    @RequestMapping(value = "/addSpecialist", method = RequestMethod.POST)
    public String saveSpecialist(@ModelAttribute("specialist") SpecialistsEntity specialist, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        specialist.setUser(user);
        QuantityEntity quantityEntity = quantityService.findById(specialist.getQuantity().getIdQuantity());
        specialist.setQuantity(quantityEntity);
        specialistService.saveSpecialist(specialist);

        SpecialistshistoryEntity specialistshistory = new SpecialistshistoryEntity();
        specialistshistory.setUser(user);
        int max = specialistService.findMaxSpecials();
        SpecialistsEntity newspecialistsEntity = specialistService.findById(max);
        specialistHistotyService.saveSpecialist(newspecialistsEntity,specialistshistory);
        SpecialistsEntity quantity2 = new SpecialistsEntity();
        model.addAttribute("specialist", quantity2);
        model.addAttribute("successMessage", "Добавление прошло успешно");
        return "addSpecialist";
    }


    @RequestMapping(value = "/{id1}/{id}/editSpecialist", method = RequestMethod.GET)
    public ModelAndView addSpecialist(@PathVariable String id) {
        SpecialistsEntity specialist = specialistService.findById(Integer.parseInt(id));
        ModelAndView model = new ModelAndView();
        model.addObject("specialist", specialist);
        model.setViewName("editSpecialist");
        return model;
    }

    @RequestMapping(value = "/{id5}/{id3}/{id4}/{id1}/{id}/editSpecialist", method = RequestMethod.GET)
    public ModelAndView addSpecialist2(@PathVariable String id) {
        SpecialistsEntity specialist = specialistService.findById(Integer.parseInt(id));
        ModelAndView model = new ModelAndView();
        model.addObject("specialist", specialist);
        model.setViewName("editSpecialist");
        return model;
    }

    @RequestMapping(value = "/editSpecialist", method = RequestMethod.POST)
    public String editSpecialist(@ModelAttribute("specialist") SpecialistsEntity specialist, Model model) {
        UsersEntity user = userService.FindByLogin(specialist.getUser().getLogin());
        specialist.setUser(user);
        QuantityEntity quantityEntity = quantityService.findById(specialist.getQuantity().getIdQuantity());
        specialist.setQuantity(quantityEntity);
        specialistService.saveSpecialist(specialist);

        SpecialistshistoryEntity specialistshistory = new SpecialistshistoryEntity();
        specialistshistory.setUser(user);
        specialistshistory.setUser(user);
        int max = specialistService.findMaxSpecials();
        SpecialistsEntity newspecialistsEntity = specialistService.findById(max);
        specialistHistotyService.saveSpecialist(newspecialistsEntity,specialistshistory);
        return "redirect:" + user.getIdUser()+"/"+ user.getIdUser()+ "/seeQuantity";
    }

    @RequestMapping(value = "/{id1}/{id}/deleteSpecialist", method = RequestMethod.GET)
    public ModelAndView deleteSpecialist(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        specialistService.deleteSpecialist(id);
        model.setViewName("delete");
        return model;
    }
    @RequestMapping(value = "/{id2}/{id3}/{id4}/{id1}/{id}/deleteSpecialist", method = RequestMethod.GET)
    public ModelAndView deleteSpecialist2(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        specialistService.deleteSpecialist(id);
        model.setViewName("delete");
        return model;
    }

}