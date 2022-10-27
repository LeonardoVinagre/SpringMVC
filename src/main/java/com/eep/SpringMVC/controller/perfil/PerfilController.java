package com.eep.SpringMVC.controller.perfil;

import com.eep.SpringMVC.model.entitys.PostEntity;
import com.eep.SpringMVC.model.entitys.ProfileEntity;
import com.eep.SpringMVC.model.repository.PerfilRepository;
import com.eep.SpringMVC.model.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class PerfilController {

    @Autowired
    private PerfilRepository repository;


    @GetMapping
    List<ProfileEntity> findAll() {

        return repository.findAll();
    }

//    @PostMapping("/siginUp")
//    public ProfileEntity register(@RequestBody ProfileEntity profile) {
//
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(profile.getPassword());
//        profile.setPassword(encodedPassword);
//        repository.save(profile);
//        return profile;
//    }
}
