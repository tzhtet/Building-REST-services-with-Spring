package com.jdc.spring.api.model.dto;

import java.util.List;

public record CourseContent(
		String title,
		String description,
		List<String> articles
		) {

}
