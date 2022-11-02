package com.eep.SpringMVC.model.repository;

import com.eep.SpringMVC.model.entitys.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Profile findByUsername(String username);

    @Query("SELECT profile.id FROM Profile profile WHERE profile.username = :username")
    Integer getUserId(@Param("username") String username);
}
