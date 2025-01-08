package com.jdc.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jdc.spring.model.BaseRepoImpl;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(repositoryBaseClass = BaseRepoImpl.class)
public class BalanceApiWebConfig implements WebMvcConfigurer{

	private String dateFormat;
	
	private String dateTimeFormat;
}
