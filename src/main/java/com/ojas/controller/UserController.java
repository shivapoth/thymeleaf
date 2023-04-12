package com.ojas.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.ojas.captcha.CaptchaGenerator;
import com.ojas.entity.UserEntity;
import com.ojas.generator.ExcelGenerator;
import com.ojas.generator.MailGenerator;
import com.ojas.generator.PdfGenetator;
import com.ojas.repo.UserRepo;

import cn.apiclub.captcha.Captcha;

@Controller
public class UserController {

	@Autowired
	private UserRepo userRepo;

	private static void getCaptcha(UserEntity uen) {

		Captcha captcha = CaptchaGenerator.createCaptcha(240, 70);

		uen.setHiddenCaptcha(captcha.getAnswer());

		uen.setCaptcha(""); // value entered by the User

		uen.setRealCaptcha(CaptchaGenerator.encodeCaptcha(captcha));

	}

	@RequestMapping(value = { "/", "/loadform" })
	public String loadForm(Model mo) {

		UserEntity u = new UserEntity();

		getCaptcha(u);

		mo.addAttribute("user", u);

		return "login";
	}

	@RequestMapping("/verify")
	public String verifyUserNameAndPassword(@ModelAttribute UserEntity user, Model model) {

		UserEntity getUser = userRepo.findByUserNameAndPassword(user.getUserName(), user.getPassword());

		if (getUser != null && user.getCaptcha().equals(user.getHiddenCaptcha())) {

			model.addAttribute("message", "Valid User..!");

			return "success";
		}

		else

		{
			model.addAttribute("message", "Invalid User");

			getCaptcha(user);

			model.addAttribute("user", user);

			return "fail";
		}

	}

	@RequestMapping(value = "/userform", method = RequestMethod.POST)
	public String userRegistrationForm(@ModelAttribute UserEntity user, Model model) {

		UserEntity save = userRepo.save(user);

		if (save != null) {

			model.addAttribute("msg", "User Registered successfully!");

			return "redirect:userform";

		} else {

			model.addAttribute("msg", "User Failed to Registered successfully!");

			return "redirect:userform";
		}

	}

	@GetMapping("/form")
	public String viewUsers(Model mo) {

		List<UserEntity> findAll = userRepo.findAll();

		mo.addAttribute("findAll", findAll);

		return "view";
	}

	@RequestMapping("/pdf")
	public String pdfGenerator(Model model) {

		List<UserEntity> findAll = userRepo.findAll();

		boolean generatePdf = PdfGenetator.GeneratePdf(findAll);

		return "view";
	}

	@RequestMapping("/excel")
	public String excelGenerator(Model mo) {

		List<UserEntity> findAll = userRepo.findAll();
		boolean excelReport = ExcelGenerator.excelReport(findAll);

		return "view";
	}

	@RequestMapping("/mail")
	public String mailGenerator(Model mo) {

		String path = "C:\\Users\\sp22282\\Documents\\userlist.pdf";

		String path1 = "C:\\Users\\sp22282\\Documents\\userlistexcel.xls";

		String email = "sidmalvi1234@gmail.com";

		boolean mail = MailGenerator.mailGen(email, path);

		boolean mail1 = MailGenerator.mailGen(email, path1);

		return "view";
	}

}
