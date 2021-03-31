package com.overread.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.overread.models.User;
import com.overread.services.UserService;

@Controller
public class MainController
{
	@GetMapping("/")
	public String getHomeLogin()
	{
		return "login";
	}
	
	@PostMapping("/login")
	public String processLogin(@RequestParam("email") String email, @RequestParam("password") String password)
	{
		boolean status = userService.findUser(email, password);
		if(status)
		{
			return "redirect:/home";
		}
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
		userService.addUser(user);
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String getHome()
	{
		return "home";
	}
	
	@Autowired
	private UserService userService;
}
