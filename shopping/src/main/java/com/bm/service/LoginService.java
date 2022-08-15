package com.bm.service;

import com.bm.dto.LoginResponse;
import com.bm.entity.CustomUserDetails;
import com.bm.entity.LoginRequest;
import com.bm.entity.User;
import com.bm.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {
	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;
	private final JwtUtil jwtUtil;

	public LoginService(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.jwtUtil = jwtUtil;
	}

	public LoginResponse login(LoginRequest loginRequest) throws Exception {
		log.info("making log in for user with username={}", loginRequest.getEmail());
		String userName = loginRequest.getEmail();
		String password = loginRequest.getPassword();

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					userName,
					password
			));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		log.info("authenticating and generating JWT for user with username={}", loginRequest.getEmail());
		CustomUserDetails customUserDetails = (CustomUserDetails)userDetailsService.loadUserByUsername(userName);
		User user = customUserDetails.getUser();
		String jwt = jwtUtil.generateToken(customUserDetails);

		return new LoginResponse(user.getName(), user.getEmail(), jwt);
	}
}
