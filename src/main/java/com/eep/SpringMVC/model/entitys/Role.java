package com.eep.SpringMVC.model.entitys;

import lombok.*;

import javax.persistence.*;
@Data
@Entity
@Table(name = "role")
@NoArgsConstructor
@RequiredArgsConstructor
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NonNull
	@Column(nullable = false, length = 32)
	private String name;

}
