package com.eep.SpringMVC.model.repository;

import com.eep.SpringMVC.model.dto.PostResumidoDto;
import com.eep.SpringMVC.model.entitys.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.eep.SpringMVC.model.dto.PostResumidoDto;
import java.util.List;
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findAll();
    @Modifying
    @Query(value = "insert into Post(titulo,post,profile_id,autor) values (:titulo,:post,:id,:userName)",nativeQuery = true)
    void savePost(@Param("id") Integer id,
                  @Param("titulo") String titulo,
                  @Param("post") String post,
                  @Param("userName") String userName);


    @Query("Select post FROM Post post WHERE post.profile.id = :id")
    List<Post> getUserPosts(@Param("id") Integer id);

    @Modifying
    @Query("update Post p set p.post = :post where p.id = :id")
    void changePost(@Param("id") Integer id,
                    @Param("post") String post);

    @Modifying
    @Query("delete from Post p where p.id = :id")
    void deletePost(@Param("id") Integer id);
}
