package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.BookEntity;

@Controller
public class BookController 
{

	@GetMapping("/addbook")
	public String addbook()
	{
		return "BookInfo";
	}
	
	@PostMapping("getbook")
	public  String getbook(@Validated BookEntity book,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("result",result);
			model.addAttribute("book",book);	
			return "BookInfo";
		}
		else
		{
			model.addAttribute("book",book);
			return "Bookdata";
		}
	}
}
