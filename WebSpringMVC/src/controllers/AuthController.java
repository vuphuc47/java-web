package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import models.Member;
import models.MemberRepository;

@Controller
public class AuthController {
	MemberRepository member = new MemberRepository();
	
	@GetMapping("/auth/signup.html")
	public String signUp() {
		return "auth.signup";
	}
	
	@PostMapping("/auth/signup.html")
	public String signUp(Member obj) {
		member.add(obj);
		return "redirect:/auth/signin.html";
	}
	
	@GetMapping("/auth/signin.html")
	public String signIn() {
		return "auth.signin";
	}
	
}
