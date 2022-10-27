package com.eep.SpringMVC.model.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.eep.SpringMVC.model.entitys.ProfileEntity;
import com.eep.SpringMVC.model.repository.PerfilRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class PerfilRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PerfilRepository repo;

    // test methods go below

    @Test
    public void testCreateUser() {
        ProfileEntity profile = new ProfileEntity();
        profile.setNome("Leonardo Rossi Vinagre");
        profile.setPassword("s2ab5on9ta");
        profile.setUsername("Lvinagre");


        ProfileEntity savedUser = repo.save(profile);

        ProfileEntity existUser = entityManager.find(ProfileEntity.class, savedUser.getId());

        assertThat(profile.getUsername()).isEqualTo(existUser.getUsername());

    }
}