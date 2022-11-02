package com.eep.SpringMVC.model.service.comment;

import com.eep.SpringMVC.model.repository.CommentRepository;
import com.eep.SpringMVC.model.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements  CommentService{

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository repository) {
        this.commentRepository = repository;
    }


}
