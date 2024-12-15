package payroll;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeNotFoundAdvice {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	String employeeNotFoundHandler(EmployeeNotFoundException ex) {
		return ex.getMessage();
	}

}
