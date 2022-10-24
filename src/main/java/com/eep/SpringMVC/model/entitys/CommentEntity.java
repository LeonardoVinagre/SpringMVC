package com.eep.SpringMVC.model.entitys;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;

}
