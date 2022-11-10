package com.eep.SpringMVC.controller.comment;

import com.eep.SpringMVC.model.service.comment.CommentService;
import com.eep.SpringMVC.model.service.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<?> saveComment(@RequestParam("idPost") Integer idPost,
                                         @RequestParam("comentario") String comentario,
                                         Authentication authentication) {
        String autor = authentication.getName();
        commentService.saveComment(idPost, comentario, autor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
