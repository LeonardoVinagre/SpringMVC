package com.eep.SpringMVC.model.entitys;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="profile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "usuario")
    private String usuario;

}
