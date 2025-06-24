package com.tcs.jwtDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@Autowired
	JwtUtil jwtUtil;
	
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		if("admin".equals(authRequest.getUsername()) && "password".equals(authRequest.getPassword())) {
			return jwtUtil.generateToken(authRequest.getUsername());
		}else {
			throw new Exception("Invalid User");
		}
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome this is secured endPoint";
	}
	
	

}
