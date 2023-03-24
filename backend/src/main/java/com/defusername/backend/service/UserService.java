package com.defusername.backend.service;

import com.defusername.backend.model.User;
import com.defusername.backend.repository.UserRepository;
import com.defusername.backend.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final AuthenticationService authenticationService;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUser(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("User not found"));
	}

	public User addNewUser(User user) {
		return userRepository.save(user);
	}

	public void removeUser(Long id) {
		userRepository.deleteById(id);
	}

	public User updateUser(Long id, User updatedUser) {
		User userToBeUpdated = userRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("User not found"));
		if (updatedUser.getUsername() != null)
			userToBeUpdated.setUsername(updatedUser.getUsername());
		if (updatedUser.getEmail() != null)
			userToBeUpdated.setEmail(updatedUser.getEmail());
		if (updatedUser.getFirstName() != null)
			userToBeUpdated.setFirstName(updatedUser.getFirstName());
		if (updatedUser.getLastName() != null)
			userToBeUpdated.setLastName(updatedUser.getLastName());
		if (updatedUser.getPassword() != null)
			userToBeUpdated.setPassword(updatedUser.getPassword());
		if (updatedUser.getUserRole() != null)
			userToBeUpdated.setUserRole(updatedUser.getUserRole());
		return userRepository.save(userToBeUpdated);
	}

}
