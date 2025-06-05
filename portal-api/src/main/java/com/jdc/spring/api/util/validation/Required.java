package com.jdc.spring.api.util.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RequiredConstraint.class)
public @interface Required {

	String message() default "{app.validation.required}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String name();

}
