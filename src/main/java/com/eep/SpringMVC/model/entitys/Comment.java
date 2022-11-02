package com.eep.SpringMVC.model.entitys;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome_autor;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = true)
    private Post post;

}