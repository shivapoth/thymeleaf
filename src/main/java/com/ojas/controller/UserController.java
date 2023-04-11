package com.ojas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ojas.entity.UserEntity;
import com.ojas.repo.UserRepo;

@Controller
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@RequestMapping("/")
	public String loadForm(Model mo) {

		UserEntity u = new UserEntity();

		mo.addAttribute("user", u);

		return "register";
	}

	@RequestMapping(value="/userform",method = RequestMethod.POST)
	public String userRegistrationForm(@ModelAttribute UserEntity user) {

		UserEntity save = userRepo.save(user);

		if (save != null)
			return "success";
		else
			return "fail";
	}
}
