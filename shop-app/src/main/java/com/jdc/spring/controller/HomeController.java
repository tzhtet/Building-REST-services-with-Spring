package com.jdc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.spring.controller.input.ProductSearch;
import com.jdc.spring.master.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
	
	private final ProductService service;
	
	@GetMapping
	String index(ProductSearch search,ModelMap model) {
		model.put("result", model);
		return "home";
	}

}
