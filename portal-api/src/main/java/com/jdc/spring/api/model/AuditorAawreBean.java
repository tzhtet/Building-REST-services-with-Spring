package com.jdc.spring.api.model;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuditorAawreBean implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable(SecurityContextHolder.getContext()).map(a -> a.getAuthentication())
				.map(a -> a.getName()).or(() -> Optional.of("System"));
	}

}
