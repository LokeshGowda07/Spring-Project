package com.loki.Jobportal.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.loki.Jobportal.dao.PortalUserDao;
import com.loki.Jobportal.dto.PortalUser;

import jakarta.validation.Valid;

@Controller
public class GeneralController {
	@Autowired
	PortalUser portalUser;
	
	@Autowired
	PortalUserDao userDao;

	@GetMapping("/")
	public String loadHome() {
		return"home.html";
	}
	@GetMapping("/signup")
	public String loadsignup(ModelMap map) {
		map.put("portalUser",portalUser);
		return"signup.html";
	}
	@GetMapping("/login")
	public String loadlogin() {
		return"login.html";
	}
	@PostMapping("/signup")
	public String signup(@Valid PortalUser portalUser,BindingResult result) {
		if(LocalDate.now().getYear()-portalUser.getDob().getYear()<18)
		{
			result.rejectValue("dob","error.dob","Age should be greater than 18");
		}
		if(!portalUser.getPassword().equals(portalUser.getConfirm_password()))
		{
			result.rejectValue("confirm_password","error.confirm_password","Password and Confirm password Should be Matching");
		}
		if(userDao.existsByEmail(portalUser.getEmail()))
		{
			result.rejectValue("email","error.email", "email should be unique");
		}
		if(result.hasErrors()) {
			return "signup.html";
		}
		else {
		return "login.html";
		}
	}
}
