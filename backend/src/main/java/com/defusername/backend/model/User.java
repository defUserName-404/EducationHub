package com.defusername.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id")
	@SequenceGenerator(
			name = "user_id",
			sequenceName = "user_id"
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_id"
	)
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "user_role")
	@Enumerated(EnumType.STRING)
	private UserConfig.UserRole userRole;

}
