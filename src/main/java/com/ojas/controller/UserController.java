package com.ojas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ojas.entity.User;

@Controller
public class UserController {

	@RequestMapping("/")
	public String loadForm(Model mo) {

		User u = new User();

		mo.addAttribute("user", u);

		return "register.html";
	}
}
