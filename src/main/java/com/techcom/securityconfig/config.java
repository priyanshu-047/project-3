package com.techcom.securityconfig;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.mysql.cj.protocol.AuthenticationProvider;

@Configuration
@EnableWebSecurity
public class config {
	
	@Autowired
	private userdetailsservice userdetailsservice;
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(custmizer -> custmizer.disable())
				.authorizeHttpRequests(request -> request.requestMatchers("/user/**").authenticated().anyRequest().permitAll())
				.formLogin(org.springframework.security.config.Customizer.withDefaults()
		            )
				.httpBasic(org.springframework.security.config.Customizer.withDefaults())
				.sessionManagement(session -> session
						.sessionCreationPolicy(org.springframework.security.config.http.SessionCreationPolicy.ALWAYS))
				.build();
	}
	
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder( DelegatingPasswordEncoder.class.cast(new BCryptPasswordEncoder())
				);
		System.out.println(userdetailsservice.loadUserByUsername("thakur00000@gmail.com"));
		provider.setUserDetailsService(userdetailsservice);
		return provider;
	}
	

}
