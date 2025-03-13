package com.jdc.spring.master.service;

import org.springframework.stereotype.Service;

import com.jdc.spring.controller.output.CategoryInfo;
import com.jdc.spring.master.repo.CategoryRepo;
import com.jdc.spring.model.PageInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryManagementService {
	
	private final CategoryRepo categoryRepo;
	
	public PageInfo<CategoryInfo> search(){
		return null;
	}

}
