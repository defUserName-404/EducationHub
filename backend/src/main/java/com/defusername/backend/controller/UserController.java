package com.defusername.backend.controller;

import com.defusername.backend.model.User;
import com.defusername.backend.security.AuthenticationRequest;
import com.defusername.backend.security.AuthenticationResponse;
import com.defusername.backend.security.AuthenticationService;
import com.defusername.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private final AuthenticationService authenticationService;
	@Autowired
	private final UserService userService;

	@GetMapping(path = "/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping
	public User getUser(@RequestParam Long id) {
		return userService.getUser(id);
	}

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> addNewUser(
			@RequestBody User user
	) {
		return ResponseEntity.ok(
				authenticationService.register(user)
		);
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(
			@RequestBody AuthenticationRequest request
	) {
		return ResponseEntity.ok(
				authenticationService.authenticate(request)
		);
	}

	@DeleteMapping
	public ResponseEntity<Long> deleteUser(@RequestParam Long id) {
		userService.removeUser(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<User> updateUser(@RequestParam Long id, @RequestBody User user) {
		return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
	}

}
