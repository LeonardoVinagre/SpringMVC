package com.eep.SpringMVC.model.repository;

import com.eep.SpringMVC.model.entitys.ProfileEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PerfilRepository extends CrudRepository<ProfileEntity, Integer> {

    //Listar Perfis
    List<ProfileEntity> findAll();
}
