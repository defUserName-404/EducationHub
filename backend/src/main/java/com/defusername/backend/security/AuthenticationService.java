package com.defusername.backend.security;

import com.defusername.backend.model.User;
import com.defusername.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.defusername.backend.util.Logger.LOG;

@RequiredArgsConstructor
@Service
public class AuthenticationService {

	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final PasswordEncoder passwordEncoder;
	@Autowired
	private final JwtService jwtService;
	@Autowired
	private final AuthenticationManager authenticationManager;

	public AuthenticationResponse register(User user) {
		user.setPassword(encodePassword(user.getPassword()));
		LOG.info(user.toString());
		userRepository.save(user);
		return AuthenticationResponse.builder()
				.token(jwtService.generateToken(user))
				.build();
	}

	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
						request.getEmail(),
						request.getPassword()
				)
		);
		var user = userRepository.findByEmail(request.getEmail())
				.orElseThrow();
		return AuthenticationResponse.builder()
				.token(jwtService.generateToken(user))
				.build();
	}

}