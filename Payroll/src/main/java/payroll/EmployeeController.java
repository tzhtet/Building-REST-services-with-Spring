package payroll;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	private final EmployeeRepository repository;
	
	public EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/employees")
	List<Employee> all(){
		return repository.findAll();
	}
	
	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		return repository.save(newEmployee);
	}
	
	
	  @GetMapping("/employees/{id}") Employee one(@PathVariable Long id) {
	  
	  return repository.findById(id) .orElseThrow(() -> new
	  EmployeeNotFoundException(id)); }
	 
	
	@PutMapping("/employees/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		return repository.findById(id)
				.map(employee -> {
					employee.setName(newEmployee.getName());
					employee.setRole(newEmployee.getRole());
					return repository.save(employee);
				})
				.orElseGet(() -> {
					return repository.save(newEmployee);
				});
		
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	/*
	 * @GetMapping("/employees/{id}") EntityModel<Employee> one(@PathVariable Long
	 * id) {
	 * 
	 * Employee employee = repository.findById(id) // .orElseThrow(() -> new
	 * EmployeeNotFoundException(id));
	 * 
	 * return EntityModel.of(employee, //
	 * linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
	 * linkTo(methodOn(EmployeeController.class).all()).withRel("employees")); }
	 */

}
