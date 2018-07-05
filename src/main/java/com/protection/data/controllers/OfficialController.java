package com.protection.data.controllers;

import com.protection.data.Exel.ExelOfficial;
import com.protection.data.models.OfficialEntity;
import com.protection.data.models.OfficialhistoryEntity;
import com.protection.data.models.UsersEntity;
import com.protection.data.services.OfficialHistoryService;
import com.protection.data.services.OfficialService;
import com.protection.data.services.UserService;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class OfficialController {

    @Autowired
    UserService userService;

    @Autowired
    OfficialService officialService;

    @Autowired
    OfficialHistoryService officialhistoryService;

    @RequestMapping(value = "/seeOfficial", method = RequestMethod.GET)
    public ModelAndView getOfficials(Model model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        List<OfficialEntity> officials = see(user);
        modelAndView.addObject("officials", officials);
        modelAndView.setViewName("seeOfficials");
        return modelAndView;
    }

    private List<OfficialEntity>  see(UsersEntity user){
        List<OfficialEntity> officialEntities = new ArrayList<>();
        List<UsersEntity> users = userService.findByAuth(user.getAuthority());
        for(int i=0;i<users.size();i++){
            officialEntities.addAll(officialService.findOfficials(users.get(i)));
        }
        return officialEntities;
    }

    @RequestMapping(value = "/{id2}/{id}/seeOfficial", method = RequestMethod.GET)//стр админа со стороны организации
    public ModelAndView getOfficial(Model model, @PathVariable String id) throws IOException {
        UsersEntity user = userService.findById(Integer.parseInt(id));
        ModelAndView modelAndView = new ModelAndView();
        List<OfficialEntity> officialEntities = see(user);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user2 = userService.FindByLogin(auth.getName());
        modelAndView.addObject("user", user2);
        modelAndView.addObject("officials", officialEntities);
        modelAndView.setViewName("seeOfficials");
        return modelAndView;
    }

    @RequestMapping(value = "/seeOfficials", method = RequestMethod.GET)// все со стороны админа
    public ModelAndView getAllOfficials(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<OfficialEntity> officialEntities = officialService.findAllOfficials();
        modelAndView.addObject("officials", officialEntities);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        modelAndView.addObject("user", user);
        modelAndView.setViewName("seeOfficials");
        return modelAndView;
    }

    private void excel(HttpServletRequest request,
                       HttpServletResponse response, File downloadFile) {
        ServletContext context = request.getServletContext();
        FileInputStream inputStream = null;
        OutputStream outStream = null;
        try {
            inputStream = new FileInputStream(downloadFile);
            response.setContentLength((int) downloadFile.length());
            response.setContentType(context.getMimeType("officials.xls"));
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

    @RequestMapping(value = "/{id2}/{id}/{id1}/excelOfficial", method = RequestMethod.GET)
    public @ResponseBody
    void downloadFiles(HttpServletRequest request,
                       HttpServletResponse response, @PathVariable String id) throws IOException {
        UsersEntity user = userService.findById(Integer.parseInt(id));
        List<OfficialEntity> official = see(user);
        ExelOfficial exel = new ExelOfficial();
        exel.writeOfficialIntoExcel(official);
        File downloadFile = new File("officials.xls");
        excel(request,response,downloadFile);
    }

    @RequestMapping(value = "/{id}/excelOfficial", method = RequestMethod.GET)
    public @ResponseBody void downloadFiles3(HttpServletRequest request,
                                             HttpServletResponse response,@PathVariable String id) throws IOException {
        List<OfficialEntity> official    = officialService.findAllOfficials();
        ExelOfficial exel = new ExelOfficial();
        exel.writeOfficialIntoExcel(official);
        File downloadFile = new File("officials.xls");
        excel(request,response,downloadFile);
    }

    @RequestMapping(value = "/{id}/seeHistoryOfficial", method = RequestMethod.GET)
    public ModelAndView getHistoryOfficial(@PathVariable String id) throws IOException {
        ModelAndView modelAndView =history(id);
        return modelAndView;
    }

    private ModelAndView history(String id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        OfficialEntity official = officialService.findById(Integer.parseInt(id));
        List<OfficialhistoryEntity> history = officialhistoryService.findOfficials(official);
        modelAndView.addObject("officials", history);
        modelAndView.setViewName("seeHistoryOfficialss");
        return modelAndView;
    }

    @RequestMapping(value = "/{id1}/{id2}/{id}/seeHistoryOfficial", method = RequestMethod.GET)
    public ModelAndView getHistoryOfficial2(@PathVariable String id) throws IOException {
        ModelAndView modelAndView = history(id);
        return modelAndView;
    }

    @RequestMapping(value = "/{id2}/{id}/{id3}/{id1}/excelOfficialHistory", method = RequestMethod.GET)
    public @ResponseBody void downloadFiles2(HttpServletRequest request,
                                             HttpServletResponse response,@PathVariable String id,@PathVariable String id3) throws IOException {
        OfficialEntity official = officialService.findById(Integer.parseInt(id3));
        List<OfficialhistoryEntity> history = officialhistoryService.findOfficials(official);
        UsersEntity user = userService.findById(Integer.parseInt(id));
        ExelOfficial exel = new ExelOfficial();
        exel.writeHistoryIntoExcel(history,official);
        File downloadFile = new File("officialHistory.xls");
        excel(request,response,downloadFile);
    }


    @RequestMapping(value = "/{id2}/{id}/excelOfficialHistory", method = RequestMethod.GET)
    public @ResponseBody void downloadFiles4(HttpServletRequest request,
                                             HttpServletResponse response,@PathVariable String id2) throws IOException {
        OfficialEntity financing = officialService.findById(Integer.parseInt(id2));
        List<OfficialhistoryEntity> history = officialhistoryService.findOfficials(financing);
        ExelOfficial exel = new ExelOfficial();
        exel.writeHistoryIntoExcel(history,financing);
        File downloadFile = new File("officialHistory.xls");
        excel(request,response,downloadFile);
    }

    @RequestMapping(value = "/addOfficials", method = RequestMethod.GET)
    public String getSongs(Model model) {
        OfficialEntity official = new OfficialEntity();
        model.addAttribute("official", official);
        return "addOfficials";
    }

    @RequestMapping(value = "/addOfficials", method = RequestMethod.POST)
    public String saveOfficials(@ModelAttribute("official") OfficialEntity official, Model model,BindingResult bindingResult) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        official.setUser(user);
        officialService.saveOfficial(official);
            OfficialEntity official2 = new OfficialEntity();
            OfficialhistoryEntity officialhistory = new OfficialhistoryEntity();
            int max = officialService.findMaxOfficial();
            OfficialEntity newOfficial = officialService.findById(max);
            officialhistory.setUsersByIdUser(user);
            officialhistoryService.saveOfficial(newOfficial, officialhistory);
            model.addAttribute("official", official2);
            model.addAttribute("successMessage", "Добавление прошло успешно");
        return "successAdding";
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
        officialhistory.setUsersByIdUser(user);
        officialhistoryService.saveOfficial(official,officialhistory);
        return "successEditing";
    }

    @RequestMapping(value = "/{id}/deleteOfficials", method = RequestMethod.GET)
    public ModelAndView deleteOfficial(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        officialService.deleteUser(id);
        model.setViewName("successDeleting");
        return model;
    }

    @RequestMapping(value = "/{id2}/{id1}/{id}/deleteOfficials", method = RequestMethod.GET)
    public ModelAndView deleteOfficial2(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        officialService.deleteUser(id);
        model.setViewName("successDeleting");
        return model;
    }

}