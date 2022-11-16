package com.eep.SpringMVC.model.repository;

import com.eep.SpringMVC.model.entitys.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Modifying
    @Query(value = "insert into Comment(comentario, nome_autor, post_id) values (:comentario,:autor,:idPost)",nativeQuery = true)
    void saveComment(@Param("idPost") Integer idPost,
                     @Param("comentario") String comentario,
                     @Param("autor") String autor);

    @Modifying
    @Query("delete from Comment comment where comment.id = :id")
    void deleteCommentById(@Param("id") Integer id);

    @Query(value = "select id from comment where post_id = :idPost", nativeQuery = true)
    List<Integer> findCommentByPostId(@Param("idPost") Integer idPost);
}
