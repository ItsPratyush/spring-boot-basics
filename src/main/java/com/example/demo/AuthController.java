package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	public UserRepository userRepo;
	
	@Autowired
	public JwtUtil jwtUtil;
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@PostMapping("/signup")
	public String signup(@RequestBody AppUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("USER");
		userRepo.save(user);
		return "User registered successfully!";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody AppUser user) {
		AppUser dbUser = userRepo.findByUsername(user.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found."));
		if (passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
			return jwtUtil.generateToken(user.getUsername());
		} else {
			throw new RuntimeException("Invalid credentials.");
		}
	}

}
