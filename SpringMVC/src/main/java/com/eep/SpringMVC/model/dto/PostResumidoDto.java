package com.eep.SpringMVC.model.dto;

import com.eep.SpringMVC.model.entitys.Comment;
import com.eep.SpringMVC.model.entitys.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResumidoDto {

    public Integer id;


    public String titulo;


    public String post;


    public String autor;


    public List<Comment> comments;


}
