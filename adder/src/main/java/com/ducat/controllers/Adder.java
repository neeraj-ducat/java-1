package com.ducat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Adder {

	
	// Method to process the request of the home page
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	
	// Method to process the request of adding numbers.
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView sum( 
		@RequestParam("num1")  int a, 
		@RequestParam("num2")  int b)
	{
		// Request processing logic
		int c = a+b;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		mav.addObject("sum", c);
		return mav;
	}
	
}
