package com.eep.SpringMVC.model.service.comment;

import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    void saveComment(Integer idPost, String comentario, String autor);

    void deleteComment(Integer id);
}
