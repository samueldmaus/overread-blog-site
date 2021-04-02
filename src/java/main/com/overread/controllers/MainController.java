package com.overread.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.overread.models.User;
import com.overread.services.UserService;

@Controller
public class MainController
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String getIndex()
	{
		return "index";
	}
	
	@GetMapping("/login")
	public String getHomeLogin()
	{
		return "login";
	}
	
	@GetMapping("/register")
	public String getRegister(Model model)
	{
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String processRegister(@ModelAttribute("user") User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.addUser(user);
		return "redirect:/index";
	}
}
