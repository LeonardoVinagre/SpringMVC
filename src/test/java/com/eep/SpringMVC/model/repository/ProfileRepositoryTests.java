package com.eep.SpringMVC.model.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.eep.SpringMVC.model.entitys.Profile;
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
public class ProfileRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProfileRepository repo;

    // test methods go below

    @Test
    public void testCreateUser() {
        Profile profile = new Profile();
        profile.setNome("Leonardo Rossi Vinagre");
        profile.setPassword("s2ab5on9ta");
        profile.setUsername("Lvinagre");


        Profile savedUser = repo.save(profile);

        Profile existUser = entityManager.find(Profile.class, savedUser.getId());

        assertThat(profile.getUsername()).isEqualTo(existUser.getUsername());

    }
}