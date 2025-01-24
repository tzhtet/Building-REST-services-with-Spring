package com.jdc.spring.api.output;

import java.time.LocalDateTime;

import com.jdc.spring.model.Role;
import com.jdc.spring.model.Status;

public record ProfileInfo(
		int id,
		String name,
		Role role,
		String email,
		String phone,
		Status status,
		LocalDateTime createAt,
		String createdBy,
		LocalDateTime lastUpdateAt,
		String lastUpdateBy
		) {

}
