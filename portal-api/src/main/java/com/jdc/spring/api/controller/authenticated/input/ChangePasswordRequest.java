package com.jdc.spring.api.controller.authenticated.input;

import com.jdc.spring.api.util.validation.Required;

public record ChangePasswordRequest(
		@Required(name = "Email")
		String email,
		@Required(name = "Old Password")
		String oldPassword,
		@Required(name = "New Password")
		String newPassword
		) {

}
