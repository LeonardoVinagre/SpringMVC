package com.eep.SpringMVC.model.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name="profile")
@RequiredArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    @NonNull
    private String nome;

    @Column(nullable = false, length = 45)
    @NonNull
    private String username;

    @Column(nullable = false, length = 64)
    @NonNull
    private String password;

    @NonNull
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "profile_roles",
            joinColumns = @JoinColumn(
                    name = "profile_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", nullable = true)
    private List<Post> posts;
}
