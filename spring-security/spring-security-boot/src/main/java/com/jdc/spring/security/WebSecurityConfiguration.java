package com.jdc.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfiguration {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(req -> {
			req.dispatcherTypeMatchers(DispatcherType.INCLUDE,DispatcherType.FORWARD,
					DispatcherType.ERROR
					).permitAll();
			req.requestMatchers("/","/login","/signup","/resources/**").permitAll();
			req.requestMatchers("/admin/**").permitAll();
			req.anyRequest().authenticated();
		});
		http.formLogin(form -> {
			form.loginPage("/login");
			form.loginProcessingUrl("/login");
			form.defaultSuccessUrl("/",true);
		});
		return null;
	}

}
