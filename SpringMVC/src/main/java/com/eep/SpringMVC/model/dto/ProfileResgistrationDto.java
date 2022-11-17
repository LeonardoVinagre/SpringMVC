package com.eep.SpringMVC.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResgistrationDto {
    private String nome;
    private String password;
    private String username;
}
