package com.jdc.spring.api.model.entity.converter;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdc.spring.api.util.exceptions.ApiSystemException;

import jakarta.persistence.AttributeConverter;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class IntegerMapConverter implements AttributeConverter<Map<String, Integer>, String>{
	
	private final ObjectMapper objectMapper;
	
	@Override
	public String convertToDatabaseColumn(Map<String, Integer> attribute) {
		if(null != attribute && !attribute.isEmpty()) {
			try {
				return objectMapper.writeValueAsString(attribute);
			} catch (JsonProcessingException e) {
				throw new ApiSystemException(e);
			}
		}
		return null;
	}

	@Override
	public Map<String, Integer> convertToEntityAttribute(String dbData) {
		return null;
	}

}
