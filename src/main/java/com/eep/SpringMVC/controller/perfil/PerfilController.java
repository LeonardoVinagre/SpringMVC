package com.eep.SpringMVC.controller.perfil;

import com.eep.SpringMVC.model.entitys.PostEntity;
import com.eep.SpringMVC.model.entitys.ProfileEntity;
import com.eep.SpringMVC.model.repository.PerfilRepository;
import com.eep.SpringMVC.model.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class PerfilController {

    @Autowired
    private PerfilRepository repository;


    @GetMapping
    List<ProfileEntity> findAll(){
        return repository.findAll();
    }


}
