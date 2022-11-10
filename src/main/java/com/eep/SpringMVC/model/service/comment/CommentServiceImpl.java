package com.eep.SpringMVC.model.service.comment;

import com.eep.SpringMVC.model.repository.CommentRepository;
import com.eep.SpringMVC.model.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CommentServiceImpl implements  CommentService{

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository repository) {
        this.commentRepository = repository;
    }

    @Override
    @Transactional
    public void saveComment(Integer idPost, String comentario, String autor) {
        commentRepository.saveComment(idPost, comentario, autor);
    }
}
