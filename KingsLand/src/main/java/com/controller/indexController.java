package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.OrdersDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.User;

@Controller

public class indexController {

	@Autowired
	UserDaoImpl userDaoImpl;

	@Autowired
	ProductDaoImpl productDaoImpl;

	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired
	CartDaoImpl cartDaoImpl;
	
	@Autowired
	OrdersDaoImpl ordersDaoImpl;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/index")
	public String home() {
		return "index";
	}

	@RequestMapping("/goToRegister")
	public String goToRegister() {
		return "register";
	}
	

	@RequestMapping("/aboutUs")
	public String aboutUs() {
		return "aboutUs";
	}
	
	

	@RequestMapping(value = "/goToRegister", method = RequestMethod.GET)
	public ModelAndView Register() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new User());
		mv.setViewName("register");
		return mv;
	}

	@RequestMapping(value = "/saveRegister", method = RequestMethod.POST)
	public ModelAndView saveRegister(@Valid @ModelAttribute("user") User user, BindingResult result) {

		ModelAndView mv = new ModelAndView();
		if(result.hasErrors())
		{
			mv.setViewName("register");
			return mv;
		}
		else
		{
		user.setRole("ROLE_USER");

		userDaoImpl.insertUser(user);
		mv.setViewName("index");
		return mv;
		}
	}

	@RequestMapping(value = "/productCustList")
	public ModelAndView getCustTable(@RequestParam("cid") int cid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("prodList", productDaoImpl.getProdByCatId(cid));
		mv.setViewName("productCustList");
		return mv;

	}

	@ModelAttribute
	public void getData(Model m) {
		m.addAttribute("catList", categoryDaoImpl.retrive());

	}

	@RequestMapping("/goToLogin")
	public String login()
	{
	return "login";
	}
	
	@RequestMapping("/goToAdminLogin")
	public String adminlogin()
	{
	return "adminLogin";
	}
		
	@RequestMapping("/userLogged")
	public String userLogged()
	{
	return "redirect:/index";
	}

	@RequestMapping("/error")
	public String error()
	{
	return "error";
	}

	@RequestMapping("/reLogin")
	public String relogin()
	{
	return "redirect:/goToLogin";
	}
	
	
}
