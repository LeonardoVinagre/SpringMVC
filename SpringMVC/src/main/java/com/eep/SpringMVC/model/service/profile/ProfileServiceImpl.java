package com.eep.SpringMVC.model.service.profile;

import com.eep.SpringMVC.model.dto.ProfileResgistrationDto;
import com.eep.SpringMVC.model.entitys.Profile;
import com.eep.SpringMVC.model.entitys.Role;
import com.eep.SpringMVC.model.repository.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService{

    private ProfileRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public ProfileServiceImpl(ProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public Profile save(ProfileResgistrationDto profileDto) {
        Profile profile = new Profile(profileDto.getNome(), profileDto.getUsername(), passwordEncoder.encode(profileDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

        return repository.save(profile);
    }

    @Override
    public Integer getUserId(String username) {
        return repository.getUserId(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Profile profile = repository.findByUsername(username);
        if(profile == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(profile.getUsername(), profile.getPassword(), mapRolesToAuthorities(profile.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
