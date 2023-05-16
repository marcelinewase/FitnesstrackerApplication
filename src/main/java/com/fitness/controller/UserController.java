package com.fitness.controller;


import com.fitness.model.Fitness;
import com.fitness.model.UserFitness;
import com.fitness.serviceLayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

      @Autowired
      private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model)
    {
        model.addAttribute("registerRequest", new UserFitness());
        return "register_page";
    }


    @GetMapping("/login")
    public String getLoginPage(Model model)
    {
        model.addAttribute("loginRequest", new UserFitness());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserFitness user){
        System.out.println("register Request" + user);
        UserFitness registeredUser=userService.registerUser(user.getLogin(), user.getPassword(), user.getEmail());
        return registeredUser== null ? "error_Page" : "redirect:/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute UserFitness user, Model model){
        System.out.println("login Request" + user);
        UserFitness authenticated=userService.authenticate(user.getEmail(), user.getPassword());
        if (authenticated !=null) {

            model.addAttribute("fitness", new Fitness());
            return "fitness_form";
        }else{
            return "error_Page";
        }
    }

}

