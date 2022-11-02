package com.eep.SpringMVC.model.repository;

import com.eep.SpringMVC.model.entitys.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findAll();
    @Modifying
    @Query(value = "insert into Post(titulo,post,profile_id) values (:titulo,:post,:id)",nativeQuery = true)
    void savePost(@Param("id") Integer id,
                  @Param("titulo") String titulo,
                  @Param("post") String post);


    @Query("Select post FROM Post post WHERE post.id = :id")
    List<Post> getUserPosts(@Param("id") Integer id);
}
