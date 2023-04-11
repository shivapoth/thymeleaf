package com.ojas.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.ojas.entity.UserEntity;
import com.ojas.generator.ExcelGenerator;
import com.ojas.generator.PdfGenetator;
import com.ojas.repo.UserRepo;

@Controller
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@RequestMapping(value = { "/", "/loadform" })
	public String loadForm(Model mo) {

		UserEntity u = new UserEntity();

		mo.addAttribute("user", u);

		return "register";
	}

	@RequestMapping(value = "/userform", method = RequestMethod.POST)
	public String userRegistrationForm(@ModelAttribute UserEntity user) {

		UserEntity save = userRepo.save(user);

		if (save != null)
			return "success";
		else
			return "fail";
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
		String msg = "";
		if (generatePdf)
			msg = "Pdf Generated";
		model.addAttribute("msg", msg);
		return "view";
	}

	@RequestMapping("/excel")
	public String excelGenerator(Model mo) {

		List<UserEntity> findAll = userRepo.findAll();
		boolean excelReport = ExcelGenerator.excelReport(findAll);
		String msg = "";
		if (excelReport)
			msg = "Excel Generated";
		mo.addAttribute("msg", msg);
		return "view";
	}
}
