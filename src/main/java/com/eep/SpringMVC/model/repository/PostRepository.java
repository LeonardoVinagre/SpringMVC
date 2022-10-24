package com.eep.SpringMVC.model.repository;

import com.eep.SpringMVC.model.entitys.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Integer> {
    List<PostEntity> findAll();
}
