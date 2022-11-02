package com.eep.SpringMVC.controller.comment;

import com.eep.SpringMVC.model.service.comment.CommentService;
import com.eep.SpringMVC.model.service.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ProfileService profileService;

//    @PostMapping
//    ResponseEntity<?> comment(@RequestParam("comment") String comment,
//
//                              Authentication authentication) {
//
//        Integer userId = profileService.getUserId(authentication.getName());
//    }
}
