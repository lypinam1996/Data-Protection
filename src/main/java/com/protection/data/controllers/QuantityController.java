package com.protection.data.controllers;

import com.protection.data.models.QuantityEntity;
import com.protection.data.models.QuantityhistoryEntity;
import com.protection.data.models.UsersEntity;
import com.protection.data.services.QuantityHistoryService;
import com.protection.data.services.QuantityService;
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
public class QuantityController {

    @Autowired
    UserService userService;

    @Autowired
    QuantityService quantityService;
    @Autowired
    QuantityHistoryService quantityHistoryService;


    @RequestMapping(value = "/seeQuantity", method = RequestMethod.GET)
    public ModelAndView getQuantities(Model model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        List<QuantityEntity> quantities = quantityService.findQuantities(user);
        modelAndView.addObject("quantities", quantities);
        modelAndView.setViewName("seeQuantity");
        return modelAndView;
    }

    @RequestMapping(value = "/{id1}/{id}/seeQuantity", method = RequestMethod.GET)
    public ModelAndView getQuantities2(Model model,@PathVariable String id) throws IOException {
        UsersEntity user = userService.findById(Integer.parseInt(id));
        ModelAndView modelAndView = new ModelAndView();
        List<QuantityEntity> quantities = quantityService.findQuantities(user);
        modelAndView.addObject("quantities", quantities);
        modelAndView.setViewName("seeQuantity2");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/seeHistoryQuantity", method = RequestMethod.GET)
    public ModelAndView getHistoryOfficials(@PathVariable String id) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        QuantityEntity quantityEntity = quantityService.findById(Integer.parseInt(id));
        List<QuantityhistoryEntity> history = quantityHistoryService.findQuantities(quantityEntity);
        modelAndView.addObject("quantities", history);
        modelAndView.setViewName("/seeHistoryQuantity");
        return modelAndView;
    }

    @RequestMapping(value = "/{id1}/{id2}/{id}/seeHistoryQuantity", method = RequestMethod.GET)
    public ModelAndView getHistoryOfficials2(@PathVariable String id) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        QuantityEntity quantityEntity = quantityService.findById(Integer.parseInt(id));
        List<QuantityhistoryEntity> history = quantityHistoryService.findQuantities(quantityEntity);
        modelAndView.addObject("quantities", history);
        modelAndView.setViewName("/seeHistoryQuantity");
        return modelAndView;
    }


    @RequestMapping(value = "/addQuantity", method = RequestMethod.GET)
    public String getSongs(Model model) {
        QuantityEntity quantity = new QuantityEntity();
        model.addAttribute("quantity", quantity);
        return "addQuantity";
    }

    @RequestMapping(value = "/addQuantity", method = RequestMethod.POST)
    public String saveOfficials(@ModelAttribute("official") QuantityEntity quantity, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        quantity.setUser(user);
        quantityService.saveQuantity(quantity);
        QuantityhistoryEntity quantityhistory = new QuantityhistoryEntity();
        int max = quantityService.findMaxOfficial();
        QuantityEntity newQuantity = quantityService.findById(max);
        quantityHistoryService.saveQuantity(newQuantity,quantityhistory);
        QuantityEntity quantity2 = new QuantityEntity();
        model.addAttribute("quantity", quantity2);
        model.addAttribute("successMessage", "Добавление прошло успешно");
        return "addQuantity";
    }


    @RequestMapping(value = "/{id}/editQuantity", method = RequestMethod.GET)
    public ModelAndView addOfficials(@PathVariable String id) {
        QuantityEntity quantity = quantityService.findById(Integer.parseInt(id));
        ModelAndView model = new ModelAndView();
        model.addObject("quantity", quantity);
        model.setViewName("editQuantity");
        return model;
    }

    @RequestMapping(value = "/{id1}/{id2}/{id}/editQuantity", method = RequestMethod.GET)
    public ModelAndView addOfficials2(@PathVariable String id) {
        QuantityEntity quantity = quantityService.findById(Integer.parseInt(id));
        ModelAndView model = new ModelAndView();
        model.addObject("quantity", quantity);
        model.setViewName("editQuantity");
        return model;
    }


    @RequestMapping(value = "/editQuantity", method = RequestMethod.POST)
    public String editOfficial(@ModelAttribute("quantity") QuantityEntity quantity, Model model) {
        UsersEntity user = userService.FindByLogin(quantity.getUser().getLogin());
        quantity.setUser(user);
        quantityService.saveQuantity(quantity);
        QuantityhistoryEntity quantityhistory = new QuantityhistoryEntity();
        quantityHistoryService.saveQuantity(quantity,quantityhistory);
        return "redirect:" + user.getIdUser()+"/"+ user.getIdUser()+ "/seeQuantity";
    }

    @RequestMapping(value = "/{id}/deleteQuantity", method = RequestMethod.GET)
    public ModelAndView deleteQuantity(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        quantityService.deleteQuantity(id);
        model.setViewName("delete");
        return model;
    }
    @RequestMapping(value = "/{id2}/{id3}/{id}/deleteQuantity", method = RequestMethod.GET)
    public ModelAndView deleteQuantity2(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        quantityService.deleteQuantity(id);
        model.setViewName("delete");
        return model;
    }

}