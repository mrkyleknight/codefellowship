package com.codefellowship.codefellowship.controllers;

import com.codefellowship.codefellowship.models.ApplicationUser;
import com.codefellowship.codefellowship.controllers.ApplicationUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationUserController {

    @Autowired
    private ApplicationUser applicationUserService;

    // Render the signup page
    @GetMapping("/signup")
    public String getSignup() {
        return "signup";
    }


    @PostMapping("/signup")
    public String postSignup(@RequestParam String username, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String dateOfBirth, @RequestParam String bio, Model model) {
        try {
            ApplicationUser newUser = new ApplicationUser(username, password, firstName, lastName, dateOfBirth, bio);
            applicationUserService.registerUser(newUser);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }


    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }


}

