package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dao.ProductDao;
import com.entity.ProductEntity;

@Controller
public class AddProduct 
{

	@Autowired
	ProductDao productdao;
	
	@GetMapping("/product")
	public String product()
	{
		return "Product";
	}
	
	@PostMapping("addproduct")
	public String addProduct(ProductEntity product)
	{
		System.out.println("Name: "+product.getProductname());
		System.out.println("Price: "+product.getPrice());
		System.out.println("Qty: "+product.getQty());
		//model.addAttribute("productentity",product);
		
		productdao.addproduct(product);
		return "Productinfo";
	}
	
	@GetMapping("/listproduct")
	public String listproducts(Model model)
	{
		List<ProductEntity> products=productdao.listproducts();
		model.addAttribute("products", products);
		return "listProducts";
	}
	
	@GetMapping("/searchproduct")
	public String searchproduct()
	{
		
		return "SearchProduct";
	}
	@PostMapping("searchname")
	public String searchname(String productname,Model model)
	{
		List<ProductEntity> products=productdao.searchproduct(productname);
		model.addAttribute("products", products);
		return "listProducts";
	}
}
