package com.protection.data.controllers;

import com.protection.data.Exel.ExelSpecialist;
import com.protection.data.models.QuantityEntity;
import com.protection.data.models.SpecialistsEntity;
import com.protection.data.models.SpecialistshistoryEntity;
import com.protection.data.models.UsersEntity;
import com.protection.data.services.QuantityService;
import com.protection.data.services.SpecialistHistotyService;
import com.protection.data.services.SpecialistService;
import com.protection.data.services.UserService;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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
         ModelAndView model = new ModelAndView();
         model.addObject("user", user);
         List<SpecialistsEntity> specialists = see(user, quantity);
         model.addObject("specialists", specialists);
         model.setViewName("seeSpecialist");
         return model;
     }

    @RequestMapping(value = "/{id}/seeSpecialists", method = RequestMethod.GET)
    public ModelAndView getQuantities2(@PathVariable String id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView model = new ModelAndView();
        UsersEntity user = userService.FindByLogin(auth.getName());
        model.addObject("user", user);
        QuantityEntity quantity = quantityService.findById(Integer.parseInt(id));
        List<SpecialistsEntity> specialists = new ArrayList<>();
        specialists=specialistService.findSpecialist(quantity);
        model.addObject("specialists", specialists);
        model.setViewName("seeSpecialist");
        return model;
    }


    private List<SpecialistsEntity>  see(UsersEntity user,QuantityEntity quantity){
        List<SpecialistsEntity> specialists = new ArrayList<>();
        List<UsersEntity> users = userService.findByAuth(user.getAuthority());
        for(int i=0;i<users.size();i++){
            specialists.addAll(specialistService.findSpecialist(users.get(i),quantity));
        }
        return specialists;
    }

    @RequestMapping(value = "/{id2}/{id1}/{id}/seeSpecialist", method = RequestMethod.GET)
    public ModelAndView getQuantities2(@PathVariable String id, @PathVariable String id1) {
        UsersEntity user = userService.findById(Integer.parseInt(id1));
        QuantityEntity quantity = quantityService.findById(Integer.parseInt(id));
        List<SpecialistsEntity> specialists = see(user,quantity);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user2 = userService.FindByLogin(auth.getName());
        ModelAndView model = new ModelAndView();
        model.addObject("user", user2);
        model.addObject("specialists", specialists);
        model.setViewName("seeSpecialist");
        return model;
    }


    private void excel(HttpServletRequest request,
                       HttpServletResponse response, File downloadFile) {
        ServletContext context = request.getServletContext();
        FileInputStream inputStream = null;
        OutputStream outStream = null;
        try {
            inputStream = new FileInputStream(downloadFile);
            response.setContentLength((int) downloadFile.length());
            response.setContentType(context.getMimeType("Specialist.xls"));
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
            response.setHeader(headerKey, headerValue);
            outStream = response.getOutputStream();
            IOUtils.copy(inputStream, outStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream)
                    inputStream.close();
                if (null != inputStream)
                    outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    @RequestMapping(value = "/{id2}/{id}/{id1}/{id3}/excelSpecialist", method = RequestMethod.GET)
    public @ResponseBody
    void downloadFiles(HttpServletRequest request,
                       HttpServletResponse response, @PathVariable String id, @PathVariable String id1) throws IOException {
        UsersEntity user = userService.findById(Integer.parseInt(id));
        QuantityEntity quantityEntity = quantityService.findById(Integer.parseInt(id1));
        List<SpecialistsEntity> specialist = see(user,quantityEntity);
        ExelSpecialist exel = new ExelSpecialist();
        exel.writeFinancingIntoExcel(specialist,quantityEntity);
        File downloadFile = new File("Specialist.xls");
        excel(request,response,downloadFile);
    }

    @RequestMapping(value = "/{id}/{id1}/excelSpecialist", method = RequestMethod.GET)
    public @ResponseBody void downloadFiles3(HttpServletRequest request,
                                             HttpServletResponse response,@PathVariable String id) throws IOException {
        QuantityEntity quantityEntity = quantityService.findById(Integer.parseInt(id));
        List<SpecialistsEntity> specialistsEntities = specialistService.findSpecialist(quantityEntity);
        ExelSpecialist exel = new ExelSpecialist();
        exel.writeFinancingIntoExcel(specialistsEntities,quantityEntity);
        File downloadFile = new File("Specialist.xls");
        excel(request,response,downloadFile);
    }

    @RequestMapping(value = "/{id1}/{id}/seeHistirySpecialist", method = RequestMethod.GET)
    public ModelAndView getHistoryFinancing3(@PathVariable String id) throws IOException {
        ModelAndView modelAndView =history(id);
        return modelAndView;
    }

    private ModelAndView history(String id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        SpecialistsEntity financing = specialistService.findById(Integer.parseInt(id));
        List<SpecialistshistoryEntity> history = specialistHistotyService.findSpecialist2(financing);
        modelAndView.addObject("specialists", history);
        modelAndView.setViewName("seeHistorySpecialist");
        return modelAndView;
    }


    @RequestMapping(value = "/{id3}/{id4}/{id1}/{id}/seeHistirySpecialist", method = RequestMethod.GET)
    public ModelAndView getHistirySpecialist2(@PathVariable String id) throws IOException {
        ModelAndView modelAndView =history(id);
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
        return "successEditing";
    }

    @RequestMapping(value = "/{id1}/{id}/deleteSpecialist", method = RequestMethod.GET)
    public ModelAndView deleteSpecialist(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        specialistService.deleteSpecialist(id);
        model.setViewName("successDeleting");
        return model;
    }
    @RequestMapping(value = "/{id2}/{id3}/{id4}/{id1}/{id}/deleteSpecialist", method = RequestMethod.GET)
    public ModelAndView deleteSpecialist2(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        specialistService.deleteSpecialist(id);
        model.setViewName("successDeleting");
        return model;
    }

    @RequestMapping(value = "/{id4}/{id2}/{id3}/{id}/{id1}/excelFinancingHistory", method = RequestMethod.GET)
    public @ResponseBody void downloadFiles2(HttpServletRequest request,
                                             HttpServletResponse response,@PathVariable String id,@PathVariable String id3) throws IOException {
        SpecialistsEntity financing = specialistService.findById(Integer.parseInt(id));
        QuantityEntity quantityEntity = quantityService.findById(Integer.parseInt(id3));
        List<SpecialistshistoryEntity> history = specialistHistotyService.findSpecialist2(financing);
        ExelSpecialist exel = new ExelSpecialist();
        exel.writeFinancingIntoExcel2(history,quantityEntity);
        File downloadFile = new File("Specialist.xls");
        excel(request,response,downloadFile);
    }


   @RequestMapping(value = "/{id3}/{id2}/{id}/excelFinancingHistory", method = RequestMethod.GET)
    public @ResponseBody void downloadFiles4(HttpServletRequest request,
                                             HttpServletResponse response,@PathVariable String id2,@PathVariable String id3) throws IOException {
       SpecialistsEntity financing = specialistService.findById(Integer.parseInt(id2));
       QuantityEntity quantityEntity = quantityService.findById(Integer.parseInt(id3));
       List<SpecialistshistoryEntity> history = specialistHistotyService.findSpecialist2(financing);
       ExelSpecialist exel = new ExelSpecialist();
       exel.writeFinancingIntoExcel2(history,quantityEntity);
       File downloadFile = new File("Specialist.xls");
       excel(request,response,downloadFile);
    }

}