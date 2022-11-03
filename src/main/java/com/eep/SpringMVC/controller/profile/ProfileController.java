package com.eep.SpringMVC.controller.profile;

import com.eep.SpringMVC.model.service.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService service;


    @GetMapping
    public Integer getUserId(@RequestParam("username") String username){
        Integer userId = service.getUserId(username);
        return userId;
    }
}
