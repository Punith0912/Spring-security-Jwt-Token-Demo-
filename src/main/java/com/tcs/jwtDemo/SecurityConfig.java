package com.tcs.jwtDemo;

import java.security.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	JwtFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain filteChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(requests->requests
				.antMatchers("/authenticate").permitAll()
				.anyRequest().authenticated());
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}
