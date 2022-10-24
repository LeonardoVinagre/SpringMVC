package com.eep.SpringMVC.model.entitys;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String titulo;


    private String post;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity autor;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<CommentEntity> comments;
}
