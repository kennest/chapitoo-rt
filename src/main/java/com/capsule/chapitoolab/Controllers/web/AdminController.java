package com.capsule.chapitoolab.Controllers.web;


import com.capsule.chapitoolab.Services.UserService;
import com.capsule.chapitoolab.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class AdminController {


    @Autowired
    UserService userService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {

        ModelAndView model = new ModelAndView();
        model.setViewName("pages/auth/login");

        return model;
    }

    @RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
    public ModelAndView signup() {

        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("pages/auth/signup");

        return model;
    }

    @RequestMapping(value = {"/signup"}, method = RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {

        ModelAndView model = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());

        if (userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
        }
        if (bindingResult.hasErrors()) {
            model.setViewName("pages/auth/signup");
        } else {
            userService.saveUser(user);
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new User());
            model.setViewName("pages/auth/signup");
        }

        return model;
    }

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView home() {

        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        //On recupere l'agence du user
        model.addObject("agence", user.getAgence());

        Integer nbLogements=user.getAgence().getLogements().size();
        Integer nbAbonnes=user.getAgence().getAbonnes().size();

        model.addObject("userName", user.getFirstname() + " " + user.getLastname());

        model.addObject("nb_logements",nbLogements);
        model.addObject("nb_abonnes",nbAbonnes);

        model.setViewName("/home");

        return model;
    }

    @RequestMapping(value = {"/access_denied"}, method = RequestMethod.GET)
    public ModelAndView accessDenied() {

        ModelAndView model = new ModelAndView();
        model.setViewName("pages/errors/access_denied");

        return model;
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public ModelAndView logout() {

        ModelAndView model = new ModelAndView();
        model.setViewName("pages/auth/login");

        return model;
    }

}
