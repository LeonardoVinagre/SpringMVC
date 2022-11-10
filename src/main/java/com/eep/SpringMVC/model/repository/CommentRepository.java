package com.eep.SpringMVC.model.repository;

import com.eep.SpringMVC.model.entitys.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Modifying
    @Query(value = "insert into Comment(descricao, nome_autor, post_id) values (:comentario,:autor,:idPost)",nativeQuery = true)
    void saveComment(@Param("idPost") Integer idPost,
                     @Param("comentario") String comentario,
                     @Param("autor") String autor);
}
