package com.protection.data.controllers;

import com.protection.data.Mail.GmailSender;
import com.protection.data.models.AuthoritiesEntity;
import com.protection.data.models.SubjectrfEntity;
import com.protection.data.models.UsersEntity;
import com.protection.data.services.AuthorityService;
import com.protection.data.services.SubjectService;
import com.protection.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthenticationController {

    @Autowired
    UserService userService;

    @Autowired
    AuthorityService authority;

    @Autowired
    SubjectService subjectService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        List<SubjectrfEntity> subjects = subjectService.findAllSubjects();
        List<AuthoritiesEntity> authorities = authority.findAllAuthorities();
        ModelAndView modelAndView = new ModelAndView();
        UsersEntity user = new UsersEntity();
        modelAndView.addObject("user", user);
        modelAndView.addObject("subjects", subjects);
        modelAndView.addObject("authorities", authorities);
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@ModelAttribute("user") @Valid UsersEntity user, BindingResult bindingResult) throws Exception {
        GmailSender sender = new GmailSender("lypinam1996@gmail.com", "1996090871Ml");//зарегистрировать на гугле почту откуда будет приходить письмо
        sender.sendMail("Заявка на регистрацию", "Новый пользователь хочет зарегистрироваться на сайте. Пожалуйста, подтвердите его регистрацию.", "I", "lypinam@rambler.ru");//куда будет приходить письмо
        ModelAndView modelAndView = new ModelAndView();
        UsersEntity userExists = userService.FindByLogin(user.getLogin());
        if (userExists != null) {
            bindingResult
                    .rejectValue("login", "error.login",
                            "*Данный логин занят");

        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Регистрация прошла успешно");
            modelAndView.addObject("login", user.getLogin());
            modelAndView.addObject("password", user.getPassword());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }

    @RequestMapping("/")
    String index() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.print(auth.getName());
        return "index";
    }
}
