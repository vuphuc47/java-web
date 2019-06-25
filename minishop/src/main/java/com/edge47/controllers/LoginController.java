package com.edge47.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.edge47.entity.Employees;
import com.edge47.service.EmployeesService;

@Controller
@RequestMapping("/login.html")
@SessionAttributes("email")
public class LoginController {

	@Autowired
	EmployeesService employeesService;

	@GetMapping
	public String login() {
		return "login/login";
	}

	@PostMapping
	@Transactional
	public String themnhanvien(@RequestParam String email, @RequestParam String matkhau,
			@RequestParam String nhaplaimatkhau) {
		if (matkhau.equals(nhaplaimatkhau)) {
			Employees employees = new Employees();
			employees.setEmail(email);
			employees.setMatkhau(matkhau);
			employees.setTendangnhap(email);

			boolean ktthemnv = employeesService.themnhanvien(employees);
			if(ktthemnv) {
				System.out.println("đăng kí thành công");
			}else {
				System.out.println("đăng kí thất bại");
			}
		} else {
			
		}
		return "login/login";
	}
}
