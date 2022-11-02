package com.eep.SpringMVC.model.repository;

import com.eep.SpringMVC.model.entitys.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
