package com.eep.SpringMVC.model.service.profile;

import com.eep.SpringMVC.model.dto.ProfileResgistrationDto;
import com.eep.SpringMVC.model.entitys.Profile;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService extends UserDetailsService {
    Profile save(ProfileResgistrationDto profileDto);

    Integer getUserId(String username);
}
