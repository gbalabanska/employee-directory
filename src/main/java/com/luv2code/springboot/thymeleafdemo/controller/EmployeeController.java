package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Department;
import com.luv2code.springboot.thymeleafdemo.service.DepartmentService;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	private DepartmentService departmentService;

	public EmployeeController(EmployeeService theEmployeeService, DepartmentService theDepartmentService) {
		employeeService = theEmployeeService;
		departmentService = theDepartmentService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// get the employees from db
		List<Employee> theEmployees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Employee theEmployee = new Employee();

		// get departments from service
		List<Department> theDepartments = departmentService.findAll();

		// add attributes to the model
		theModel.addAttribute("employee", theEmployee);
		theModel.addAttribute("departments", theDepartments);

		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);

		// get departments from service
		List<Department> theDepartments = departmentService.findAll();

		// set employee and departments as model attributes
		theModel.addAttribute("employee", theEmployee);
		theModel.addAttribute("departments", theDepartments);

		// send over to our form
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

		// save the employee
		employeeService.save(theEmployee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {

		// delete the employee
		employeeService.deleteById(theId);

		// redirect to /employees/list
		return "redirect:/employees/list";
	}
}
