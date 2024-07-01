package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.entity.Operations;
import com.example.demo.repository.OperationRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private OperationRepository opeRepo;
	
	@GetMapping("/")
	private String home(Model m) {
		List<Operations> list = opeRepo.findAll();
		m.addAttribute("all_employees",list);
		
		return "index";
	}
	@GetMapping("/load_form")
	private String loadForm() {
		return "add";
	}
	@GetMapping("/edit_form/{id}")
	private String editFrom(@PathVariable(value = "id")long id,Model m) {
		Optional<Operations> operation=opeRepo.findById(id);
		Operations oper = operation.get();
		m.addAttribute("operation",oper);
		
		return "edit";
	}
	@PostMapping("/save_employee")
	public String saveEmployee(@ModelAttribute Operations ope,HttpSession session) {
		opeRepo.save(ope);
		session.setAttribute("msg", "Employee Added Sucessfully...");
		return "redirect:/load_form";
	}
	
	@PostMapping("/update_employee")
	public String updateEmployee(@ModelAttribute Operations ope,HttpSession session) {
		opeRepo.save(ope);
		session.setAttribute("msg", "Updated Sucessfully...");
		return "redirect:/";
	
	}
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(value = "id")long id,HttpSession session) {
		opeRepo.deleteById(id);
		session.setAttribute("msg", "Deleted Sucessfully...");
		return "redirect:/";
	}
	
}
