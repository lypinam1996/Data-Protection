package com.protection.data.controllers;

import com.protection.data.Exel.ExelPersonal;
import com.protection.data.models.*;
import com.protection.data.services.*;
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

    @RequestMapping(value = "/seePersonal", method = RequestMethod.GET)
    public ModelAndView getOfficials(Model model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        List<PersonalinformationsystemEntity> personals = see(user);
        modelAndView.addObject("personals", personals);
        modelAndView.setViewName("seePersonals");
        return modelAndView;
    }

    private List<PersonalinformationsystemEntity>  see(UsersEntity user){
        List<PersonalinformationsystemEntity> personals = new ArrayList<>();
        List<UsersEntity> users = userService.findByAuth(user.getAuthority());
        for(int i=0;i<users.size();i++){
            personals.addAll(personalService.findPersonal(users.get(i)));
        }
        return personals;
    }

    @RequestMapping(value = "/{id2}/{id}/seePersonal", method = RequestMethod.GET)//стр админа со стороны организации
    public ModelAndView getOfficial(Model model, @PathVariable String id) throws IOException {
        UsersEntity user = userService.findById(Integer.parseInt(id));
        ModelAndView modelAndView = new ModelAndView();
        List<PersonalinformationsystemEntity> personals = see(user);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user2 = userService.FindByLogin(auth.getName());
        modelAndView.addObject("user", user2);
        modelAndView.addObject("personals", personals);
        modelAndView.setViewName("seePersonals");
        return modelAndView;
    }

    @RequestMapping(value = "/seePersonals", method = RequestMethod.GET)// все со стороны админа
    public ModelAndView getAllOfficials(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<PersonalinformationsystemEntity> personals = personalService.findAllPersonal();
        modelAndView.addObject("personals", personals);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        modelAndView.addObject("user", user);
        modelAndView.setViewName("seePersonals");
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
            response.setContentType(context.getMimeType("person.xls"));
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

    @RequestMapping(value = "/{id2}/{id}/{id1}/excelPersonal", method = RequestMethod.GET)
    public @ResponseBody
    void downloadFiles(HttpServletRequest request,
                       HttpServletResponse response, @PathVariable String id) throws IOException {
        UsersEntity user = userService.findById(Integer.parseInt(id));
        List<PersonalinformationsystemEntity> official = see(user);
        ExelPersonal exel = new ExelPersonal();
        exel.writePersonIntoExcel(official);
        File downloadFile = new File("person.xls");
        excel(request,response,downloadFile);
    }

    @RequestMapping(value = "/{id}/excelPersonal", method = RequestMethod.GET)
    public @ResponseBody void downloadFiles3(HttpServletRequest request,
                                             HttpServletResponse response,@PathVariable String id) throws IOException {
        List<PersonalinformationsystemEntity> official    = personalService.findAllPersonal();
        ExelPersonal exel = new ExelPersonal();
        exel.writePersonIntoExcel(official);
        File downloadFile = new File("person.xls");
        excel(request,response,downloadFile);
    }


    @RequestMapping(value = "/{id}/seeHistoryPersonals", method = RequestMethod.GET)
    public ModelAndView getHistoryOfficial(@PathVariable String id) throws IOException {
        ModelAndView modelAndView =history(id);
        return modelAndView;
    }

    private ModelAndView history(String id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        PersonalinformationsystemEntity official = personalService.findById(Integer.parseInt(id));
        List<PersonalinformationsystemhistoryEntity> history = personalInformationSystemHistoryService.findPersonalInformationSystemHistories(official);
        modelAndView.addObject("personals", history);
        modelAndView.setViewName("seeHistoryPersonals");
        return modelAndView;
    }

    @RequestMapping(value = "/{id1}/{id2}/{id}/seeHistoryPersonals", method = RequestMethod.GET)
    public ModelAndView getHistoryOfficial2(@PathVariable String id) throws IOException {
        ModelAndView modelAndView = history(id);
        return modelAndView;
    }

    @RequestMapping(value = "/{id2}/{id}/{id3}/{id1}/excelHistoryPersonal", method = RequestMethod.GET)
    public @ResponseBody void downloadFiles2(HttpServletRequest request,
                                             HttpServletResponse response,@PathVariable String id,@PathVariable String id3) throws IOException {
        PersonalinformationsystemEntity official = personalService.findById(Integer.parseInt(id3));
        List<PersonalinformationsystemhistoryEntity> history = personalInformationSystemHistoryService.findPersonalInformationSystemHistories(official);
        UsersEntity user = userService.findById(Integer.parseInt(id));
        ExelPersonal exel = new ExelPersonal();
        exel.writePersonIntoExcel(history,official);
        File downloadFile = new File("person.xls");
        excel(request,response,downloadFile);
    }


    @RequestMapping(value = "/{id2}/{id}/excelHistoryPersonal", method = RequestMethod.GET)
    public @ResponseBody void downloadFiles4(HttpServletRequest request,
                                             HttpServletResponse response,@PathVariable String id2) throws IOException {
        PersonalinformationsystemEntity financing = personalService.findById(Integer.parseInt(id2));
        List<PersonalinformationsystemhistoryEntity> history = personalInformationSystemHistoryService.findAllPersonalInformationSystemHistories();
        ExelPersonal exel = new ExelPersonal();
        exel.writePersonIntoExcel(history,financing);
        File downloadFile = new File("person.xls");
        excel(request,response,downloadFile);
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
        history.setUsersByIdUser(user);
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
        history.setUsersByIdUser(user);
        personalInformationSystemHistoryService.saveHistory(personal,history);
        return "successEditing";
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
        model.setViewName("successDeliting");
        return model;
    }


}