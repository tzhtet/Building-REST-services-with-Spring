package com.jdc.spring.api.controller.anonymous.output;

public record AccessTokenResponse(
		String name,
		String role,
		String aceesToken,
		String refreshToken
		) {

}
