package com.eep.SpringMVC.controller.perfil;

import com.eep.SpringMVC.model.entitys.PostEntity;
import com.eep.SpringMVC.model.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;


    @GetMapping
    List<PostEntity> getPosts(){return postRepository.findAll();}
}
