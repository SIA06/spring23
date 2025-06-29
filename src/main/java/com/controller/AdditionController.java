package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.AddEntity;

@Controller
public class AdditionController 
{
	@GetMapping("/val")
	public String takeval()
	{
		return "input";
	}
	
	@PostMapping("answer")
	public String getans(AddEntity addentity)
	{
		int no1=addentity.getNo1();
		int no2=addentity.getNo2();
		System.out.println("addition of two numbers is: "+(no1+no2));
		
		return "input";
	}
}
