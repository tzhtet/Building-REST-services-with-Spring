package com.jdc.spring.api.controller.output;

public record AccessTokenResponse(
		String name,
		String role,
		String aceesToken,
		String refreshToken
		) {

}
