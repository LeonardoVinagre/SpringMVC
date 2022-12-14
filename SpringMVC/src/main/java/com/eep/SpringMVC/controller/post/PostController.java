package com.eep.SpringMVC.controller.post;

import com.eep.SpringMVC.model.dto.PostResumidoDto;
import com.eep.SpringMVC.model.entitys.Post;
import com.eep.SpringMVC.model.repository.PostRepository;
import com.eep.SpringMVC.model.service.post.PostService;
import com.eep.SpringMVC.model.service.profile.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ProfileService profileService;

    @GetMapping
    List<Post> getPosts(){
        return postService.getPosts();
    }


    @GetMapping(path = "/userPosts")
    public ResponseEntity<?> getUserPosts(Authentication authentication) {
        Integer userId = profileService.getUserId(authentication.getName());
        List<Post> posts = postService.getUserPosts(userId);
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    @PostMapping
    ResponseEntity<?> post(@RequestParam("titulo") String titulo,@RequestParam("post") String post,
                            Authentication authentication){

        Integer userId = profileService.getUserId(authentication.getName());
        String userName = authentication.getName();
        postService.post(userId,titulo,post,userName);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/change")
    ResponseEntity<?> changePost(@RequestParam("id") Integer id,
                                 @RequestParam("post") String post) {

        postService.changePost(id, post);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(path = "/delete")
    ResponseEntity<?> deletePost(@RequestParam("id") Integer id) {
        postService.deletePost(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
