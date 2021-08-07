package com.example.cruddemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;

@Controller
@RequestMapping("/app")
public class EmployeeController {
	
	@Autowired
	EmployeeService empserv;
	
	@GetMapping("/hello")
	public String sayHello(Model model){
		
		
		
		model.addAttribute("date", new java.util.Date());
		
		return "hello";
	}

	@GetMapping("/list")
	public String getIndex(Model model){
		
		
		
		model.addAttribute("date", new java.util.Date());
		model.addAttribute("employees",empserv.findAll());
		
		return "index";
	}
	
	@GetMapping("/addEmployee")
	public String addEmployee(Model model){
		
		Employee theemployee=new Employee();
		
		model.addAttribute("employee",theemployee);
		
		return "create-employee";
	}
	
	
	@GetMapping("/error")
	public String showError(Model model){
		
		return "error";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theemployee){
		
		empserv.save(theemployee);
		
		return "redirect:/list";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("employeeId") int theId, Model model){
		
		Employee theemployee=empserv.findById(theId);
		model.addAttribute("employee", theemployee);
		
		return "create-employee";
	}
	@GetMapping("/delete")
	public String deleteById(@RequestParam("employeeId") int theId, Model model){
		
		empserv.deleteById(theId);
		
		return "redirect:/list";
	}
	
}
