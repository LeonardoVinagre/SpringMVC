package com.eep.SpringMVC.controller.profile;

import com.eep.SpringMVC.model.dto.ProfileResgistrationDto;
import com.eep.SpringMVC.model.service.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class ProfileRegistrationController {
    @Autowired
    private ProfileService service;

    @ModelAttribute("profile")
    public ProfileResgistrationDto profileResgistrationDto() {
        return new ProfileResgistrationDto();
    }

    @GetMapping
    public String registrationView() {
        return "registration";
    }

    @PostMapping
    public String register(@ModelAttribute("profile")ProfileResgistrationDto profileDto) {
        service.save(profileDto);
        return "redirect:/registration?success";
    }

}
