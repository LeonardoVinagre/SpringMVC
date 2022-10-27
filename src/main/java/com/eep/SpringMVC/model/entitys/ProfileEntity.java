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

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false, length = 45)
    private String username;

    @Column(nullable = false, length = 64)
    private String password;
}
