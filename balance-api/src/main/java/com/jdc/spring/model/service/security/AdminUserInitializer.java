package com.jdc.spring.model.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.model.entity.Account;
import com.jdc.spring.model.repo.AccountRepo;

@Service
public class AdminUserInitializer {

	@Autowired
	private AccountRepo repo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Value("${app.user.admin.name}")
	private String name;

	@Value("${app.user.admin.loginId}")
	private String loginId;

	@Value("${app.user.admin.password}")
	private String password;

	@Transactional
	public void initializeAdmin() {
		if (repo.count() == 0L) {
			var admin = new Account();
			admin.setName(name);
			admin.setLoginId(loginId);
			admin.setPassword(password);
		}
	}

}
