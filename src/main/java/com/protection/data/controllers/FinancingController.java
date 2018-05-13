package com.protection.data.controllers;

import com.protection.data.models.FinancingEntity;
import com.protection.data.models.FinancinghistoryEntity;
import com.protection.data.models.UsersEntity;
import com.protection.data.services.CryptoProtectionService;
import com.protection.data.services.FinancinService;
import com.protection.data.services.FinancingHistoryService;
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
public class FinancingController {

    @Autowired
    UserService userService;

    @Autowired
    FinancinService financinService;

    @Autowired
    FinancingHistoryService financingHistoryService;
    @Autowired
    CryptoProtectionService cryptoProtectionService;


    @RequestMapping(value = "/seeFinancing", method = RequestMethod.GET)
    public ModelAndView getAllFinancing(Model model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        List<FinancingEntity> financing = financinService.findFinancing(user);
        modelAndView.addObject("financing", financing);
        modelAndView.setViewName("seeFinancing");
        return modelAndView;
    }

   @RequestMapping(value = "/{id}/seeHistoryFinancing", method = RequestMethod.GET)
    public ModelAndView getHistoryFinancing(@PathVariable String id) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        FinancingEntity financing = financinService.findById(Integer.parseInt(id));
        List<FinancinghistoryEntity> history = financingHistoryService.findFinancing(financing);
        modelAndView.addObject("financing", history);
        modelAndView.setViewName("seeHistoryFinancing");
        return modelAndView;
    }


   @RequestMapping(value = "/addFinancing", method = RequestMethod.GET)
    public String getFinancing(Model model) {
        FinancingEntity financing = new FinancingEntity();
        model.addAttribute("financing", financing);
        return "addFinancing";
    }

    @RequestMapping(value = "/addFinancing", method = RequestMethod.POST)
    public String saveFinancing(@ModelAttribute("financing") FinancingEntity financing, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        financing.setUser(user);
        financinService.saveFinancing(financing);

        FinancingEntity financingEntity = new FinancingEntity();
        model.addAttribute("financing", financingEntity);
        FinancinghistoryEntity history= new FinancinghistoryEntity();
        int max = financinService.findMaxFinancing();
        FinancingEntity newPers = financinService.findById(max);
        financingHistoryService.saveFinancing(newPers,history);
        model.addAttribute("successMessage", "Добавление прошло успешно");
        return "addFinancing";
    }


    @RequestMapping(value = "/{id}/editFinancing", method = RequestMethod.GET)
    public String addFinancing(@PathVariable String id, Model model) {
        FinancingEntity financing = financinService.findById(Integer.parseInt(id));
        model.addAttribute("financing", financing);
        return "editFinancing";
    }

    @RequestMapping(value = "/editFinancing", method = RequestMethod.POST)
    public String editFinancing(@ModelAttribute("financing") FinancingEntity financing, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        financing.setUser(user);
        financinService.saveFinancing(financing);
        FinancinghistoryEntity history = new FinancinghistoryEntity();
        financingHistoryService.saveFinancing(financing,history);
        return "redirect:" + "/seeFinancing";
    }

    @RequestMapping(value = "/{id}/deleteFinancing", method = RequestMethod.GET)
    public ModelAndView deleteFinancing(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        financinService.deleteFinancing(id);
        model.setViewName("delete");
        return model;
    }

}