package com.jdc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.spring.controller.input.SignUpForm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("public/signup")
public class SignUpController {
	
	
	@GetMapping
	String index() {
		return "signup";
	}
	
	@PostMapping
	String signUp(
			@Validated @ModelAttribute(name = "form") SignUpForm singUpForm,
			BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(result.hasErrors()) {
			return "signup";
		}
		
		return null;
	}
	
	

}
