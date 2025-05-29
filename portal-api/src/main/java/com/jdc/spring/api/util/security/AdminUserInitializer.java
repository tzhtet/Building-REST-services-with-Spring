package com.jdc.spring.api.util.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:/admin.properties")
public class AdminUserInitializer implements ApplicationRunner{
	
	@Value("app.admin.username")
	private String username;
	
	@Value("app.admin.password")
	private String password;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {	
	}

}
