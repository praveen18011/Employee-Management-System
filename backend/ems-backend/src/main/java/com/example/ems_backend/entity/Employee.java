package com.example.ems_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="employees")
public class Employee {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email", nullable =false, unique = true)
	private String email;



	
}
