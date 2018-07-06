package com.protection.data.controllers;

import com.protection.data.Exel.ExelStates;
import com.protection.data.models.StateinformationsystehistoryEntity;
import com.protection.data.models.StateinformationsystemEntity;
import com.protection.data.models.TypeofcryptoprotectionEntity;
import com.protection.data.models.UsersEntity;
import com.protection.data.services.CryptoProtectionService;
import com.protection.data.services.StateInformationHistoryService;
import com.protection.data.services.StateInformationService;
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
public class StateInformationSystemController {

    @Autowired
    UserService userService;

    @Autowired
    StateInformationService stateInformationService;

    @Autowired
    StateInformationHistoryService stateInformationHistoryService;
    @Autowired
    CryptoProtectionService cryptoProtectionService;


    @RequestMapping(value = "/seeState", method = RequestMethod.GET)
    public ModelAndView getOfficials(Model model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        List<StateinformationsystemEntity> state = see(user);
        modelAndView.addObject("states", state);
        modelAndView.setViewName("seeState");
        return modelAndView;
    }

    private List<StateinformationsystemEntity>  see(UsersEntity user){
        List<StateinformationsystemEntity> states = new ArrayList<>();
        List<UsersEntity> users = userService.findByAuth(user.getAuthority());
        for(int i=0;i<users.size();i++){
            states.addAll(stateInformationService.findStateInformation(users.get(i)));
        }
        return states;
    }

    @RequestMapping(value = "/{id2}/{id}/seeState", method = RequestMethod.GET)//стр админа со стороны организации
    public ModelAndView getOfficial(Model model, @PathVariable String id) throws IOException {
        UsersEntity user = userService.findById(Integer.parseInt(id));
        ModelAndView modelAndView = new ModelAndView();
        List<StateinformationsystemEntity> stateinformation = see(user);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user2 = userService.FindByLogin(auth.getName());
        modelAndView.addObject("user", user2);
        modelAndView.addObject("states", stateinformation);
        modelAndView.setViewName("seeState");
        return modelAndView;
    }

    @RequestMapping(value = "/seeStates", method = RequestMethod.GET)// все со стороны админа
    public ModelAndView getAllOfficials(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<StateinformationsystemEntity> stateinformation = stateInformationService.findAllStateInformation();
        modelAndView.addObject("states", stateinformation);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        modelAndView.addObject("user", user);
        modelAndView.setViewName("seeState");
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
            response.setContentType(context.getMimeType("states.xls"));
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

    @RequestMapping(value = "/{id2}/{id}/{id1}/excelStates", method = RequestMethod.GET)
    public @ResponseBody
    void downloadFiles(HttpServletRequest request,
                       HttpServletResponse response, @PathVariable String id) throws IOException {
        UsersEntity user = userService.findById(Integer.parseInt(id));
        List<StateinformationsystemEntity> official = see(user);
        ExelStates exel = new ExelStates();
        exel.writeOfficialIntoExcel(official);
        File downloadFile = new File("states.xls");
        excel(request,response,downloadFile);
    }

    @RequestMapping(value = "/{id}/excelStates", method = RequestMethod.GET)
    public @ResponseBody void downloadFiles3(HttpServletRequest request,
                                             HttpServletResponse response,@PathVariable String id) throws IOException {
        List<StateinformationsystemEntity> official    = stateInformationService.findAllStateInformation();
        ExelStates exel = new ExelStates();
        exel.writeOfficialIntoExcel(official);
        File downloadFile = new File("states.xls");
        excel(request,response,downloadFile);
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

    @RequestMapping(value = "/{id}/seeHistiryState", method = RequestMethod.GET)
    public ModelAndView getHistoryStates3(@PathVariable String id) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        StateinformationsystemEntity stateinformationsystemEntity = stateInformationService.findById(Integer.parseInt(id));
        List<StateinformationsystehistoryEntity> history = stateInformationHistoryService.findStateInformationHistories(stateinformationsystemEntity);
        modelAndView.addObject("states", history);
        modelAndView.setViewName("seeHistoryState");
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
        stateHistory.setUsersByIdUser(user);
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
        history.setUsersByIdUser(user);
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