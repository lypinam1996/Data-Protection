package com.protection.data.controllers;

import com.protection.data.Exel.ExelFinancing;
import com.protection.data.models.FinancingEntity;
import com.protection.data.models.FinancinghistoryEntity;
import com.protection.data.models.UsersEntity;
import com.protection.data.services.CryptoProtectionService;
import com.protection.data.services.FinancinService;
import com.protection.data.services.FinancingHistoryService;
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
public class FinancingController {

    @Autowired
    UserService userService;

    @Autowired
    FinancinService financinService;

    @Autowired
    FinancingHistoryService financingHistoryService;
    @Autowired
    CryptoProtectionService cryptoProtectionService;


    @RequestMapping(value = "/seeFinancing", method = RequestMethod.GET)//стр пользователя
    public ModelAndView getAllFinancing(Model model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        List<FinancingEntity> financing=see(user);
        modelAndView.addObject("financing", financing);
        modelAndView.setViewName("seeFinancings");
        return modelAndView;
    }

    @RequestMapping(value = "/{id2}/{id}/seeFinancing", method = RequestMethod.GET)//стр админа со стороны организации
    public ModelAndView getAllFinancing2(Model model, @PathVariable String id) throws IOException {
        UsersEntity user = userService.findById(Integer.parseInt(id));
        ModelAndView modelAndView = new ModelAndView();
        List<FinancingEntity> financing = see(user);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user2 = userService.FindByLogin(auth.getName());
        modelAndView.addObject("user", user2);
        modelAndView.addObject("financing", financing);
        modelAndView.setViewName("seeFinancings");
        return modelAndView;
    }


    @RequestMapping(value = "/seeFinancings", method = RequestMethod.GET)// все со стороны админа
    public ModelAndView getAllFinancings(Model model) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        List<FinancingEntity> financing = financinService.findAllFinancing();
        modelAndView.addObject("financing", financing);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        modelAndView.addObject("user", user);
        modelAndView.setViewName("seeFinancings");
        return modelAndView;
    }

    private List<FinancingEntity>  see(UsersEntity user){
        List<FinancingEntity> financing = new ArrayList<>();
        List<UsersEntity> users = userService.findByAuth(user.getAuthority());
        for(int i=0;i<users.size();i++){
            financing.addAll(financinService.findFinancing(users.get(i)));
        }
        return financing;
    }

    private void excel(HttpServletRequest request,
                       HttpServletResponse response,File downloadFile) {
        ServletContext context = request.getServletContext();
        FileInputStream inputStream = null;
        OutputStream outStream = null;
        try {
            inputStream = new FileInputStream(downloadFile);
            response.setContentLength((int) downloadFile.length());
            response.setContentType(context.getMimeType("Сведения по текущему и планируемому финансированию мероприятий по защите информации.xls"));
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


    @RequestMapping(value = "/{id2}/{id}/{id1}/excelFinancing", method = RequestMethod.GET)
    public @ResponseBody void downloadFiles(HttpServletRequest request,
                                            HttpServletResponse response,@PathVariable String id) throws IOException {
        UsersEntity user = userService.findById(Integer.parseInt(id));
        List<FinancingEntity> financing = see(user);
        ExelFinancing exel = new ExelFinancing();
        exel.writeFinancingIntoExcel(financing,user);
        File downloadFile = new File("Сведения по текущему и планируемому финансированию мероприятий по защите информации.xls");
        excel(request,response,downloadFile);
    }

    @RequestMapping(value = "/{id}/excelFinancing", method = RequestMethod.GET)
    public @ResponseBody void downloadFiles3(HttpServletRequest request,
                                            HttpServletResponse response,@PathVariable String id) throws IOException {
        List<FinancingEntity> financing = financinService.findAllFinancing();
        ExelFinancing exel = new ExelFinancing();
        exel.writeFinancingIntoExcel(financing);
        File downloadFile = new File("Сведения по текущему и планируемому финансированию мероприятий по защите информации.xls");
        excel(request,response,downloadFile);
    }

    @RequestMapping(value = "/{id2}/{id}/{id3}/{id1}/excelFinancingHistory", method = RequestMethod.GET)
    public @ResponseBody void downloadFiles2(HttpServletRequest request,
                                             HttpServletResponse response,@PathVariable String id,@PathVariable String id3) throws IOException {
        FinancingEntity financing = financinService.findById(Integer.parseInt(id3));
        List<FinancinghistoryEntity> history = financingHistoryService.findFinancing(financing);
        UsersEntity user = userService.findById(Integer.parseInt(id));
        ExelFinancing exel = new ExelFinancing();
        exel.writeFinancingHistoryIntoExcel(history,user);
        File downloadFile = new File("Сведения по текущему и планируемому финансированию мероприятий по защите информации.xls");
        excel(request,response,downloadFile);
    }


    @RequestMapping(value = "/{id2}/{id}/excelFinancingHistory", method = RequestMethod.GET)
    public @ResponseBody void downloadFiles4(HttpServletRequest request,
                                             HttpServletResponse response,@PathVariable String id2) throws IOException {
        FinancingEntity financing = financinService.findById(Integer.parseInt(id2));
        List<FinancinghistoryEntity> history = financingHistoryService.findFinancing(financing);
        ExelFinancing exel = new ExelFinancing();
        exel.writeFinancingHistoryIntoExcel(history,financing);
        File downloadFile = new File("Сведения по текущему и планируемому финансированию мероприятий по защите информации.xls");
        excel(request,response,downloadFile);
    }

    @RequestMapping(value = "/{id}/seeHistoryFinancings", method = RequestMethod.GET)
    public ModelAndView getHistoryFinancing3(@PathVariable String id) throws IOException {
        ModelAndView modelAndView =history(id);
        return modelAndView;
    }

    private ModelAndView history(String id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = userService.FindByLogin(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        FinancingEntity financing = financinService.findById(Integer.parseInt(id));
        List<FinancinghistoryEntity> history = financingHistoryService.findFinancing(financing);
        modelAndView.addObject("financing", history);
        modelAndView.setViewName("seeHistoryFinancings");
        return modelAndView;
    }

    @RequestMapping(value = "/{id1}/{id2}/{id}/seeHistoryFinancings", method = RequestMethod.GET)
    public ModelAndView getHistoryFinancing2(@PathVariable String id) throws IOException {
        ModelAndView modelAndView =history(id);
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
        history.setUsersByIdUser(user);
        int max = financinService.findMaxFinancing();
        FinancingEntity newPers = financinService.findById(max);
        financingHistoryService.saveFinancing(newPers,history);
        model.addAttribute("successMessage", "Добавление прошло успешно");
        return "successAdding";
    }


    @RequestMapping(value = "/{id}/editFinancing", method = RequestMethod.GET)
    public String addFinancing(@PathVariable String id, Model model) {
        FinancingEntity financing = financinService.findById(Integer.parseInt(id));
        model.addAttribute("financing", financing);
        return "editFinancing";
    }

    @RequestMapping(value = "/{id1}/{id2}/{id}/editFinancing", method = RequestMethod.GET)
    public String addFinancing2(@PathVariable String id, Model model) {
        FinancingEntity financing = financinService.findById(Integer.parseInt(id));
        model.addAttribute("financing", financing);
        return "editFinancing";
    }

    @RequestMapping(value = "/editFinancing", method = RequestMethod.POST)
    public String editFinancing(@ModelAttribute("financing") FinancingEntity financing, Model model) {
        UsersEntity user = userService.FindByLogin(financing.getUser().getLogin());
        financing.setUser(user);
        financinService.saveFinancing(financing);
        FinancinghistoryEntity history = new FinancinghistoryEntity();
        history.setUsersByIdUser(user);
        financingHistoryService.saveFinancing(financing,history);
        return "/successEditing";
}


    @RequestMapping(value = "/{id3}/{id2}/{id}/deleteFinancing", method = RequestMethod.GET)
    public ModelAndView deleteFinancing(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        financinService.deleteFinancing(id);
        model.setViewName("successDeleting");
        return model;
    }
    @RequestMapping(value = "/{id}/deleteFinancing", method = RequestMethod.GET)
    public ModelAndView deleteFinancing2(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        financinService.deleteFinancing(id);
        model.setViewName("successDeleting");
        return model;
    }

}