package com.example.springbootproject.controller;

import com.example.springbootproject.entity.Employee;
import com.example.springbootproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService){
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> theEmployees = employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);
		return "/employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "/employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate/{employeeId}")
	public String showFormForUpdate(@PathVariable("employeeId") int theId,  Model theModel ) {
		Employee theEmployee = employeeService.findById(theId);
		theModel.addAttribute("employee", theEmployee);
		return "/employees/employee-update-form";
	}

	@PostMapping("/update/{employeeId}")
	public String updateUser(@PathVariable("employeeId") int theId, @Valid Employee theEmployee, BindingResult result, Model theModel ){

		if(result.hasErrors()){
			theEmployee.setId(theId);
			return "/employees/employee-update-form";
		}
		employeeService.save(theEmployee);
		theModel.addAttribute("employee", theEmployee);
		return "redirect:/employees/list";

	}

	@GetMapping("/delete/{employeeId}")
	public String deleteUser(@PathVariable("employeeId") int theId) {
		employeeService.deleteById(theId);
		return "redirect:/employees/list";
	}

}