package com.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dao.userDao;
import com.entity.UserEntity;
import com.service.MailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController 
{
	@Autowired
	userDao userDao;
	
	@Autowired
	MailService mailservice;
	
	@Autowired
	Cloudinary cloudinary;

	
	@GetMapping({"/","register"})
	public String singup()
	{
		return "Register";//jsp file name
	}
	@GetMapping("/login")
	public String signIn()
	{
		return "Login";//jsp file name
	}
	@PostMapping("saveuser")
	public String saveUser(UserEntity userentity,@RequestParam MultipartFile ProfilePic)
	{
		System.out.println(userentity.getFirstName());
		System.out.println(userentity.getEmail());
		System.out.println(userentity.getPassword());
		
		System.out.println(ProfilePic.getOriginalFilename());
		System.out.println(ProfilePic.getSize());
		if(ProfilePic==null||ProfilePic.getSize()==0||!(ProfilePic.getOriginalFilename().endsWith(".jpg")))
		{
			return "Register";
			
		}
		
		try {

			Map result = cloudinary.uploader().upload(ProfilePic.getBytes(), ObjectUtils.emptyMap());

			System.out.println(result);
			String imagePath = result.get("secure_url").toString();
			System.out.println(imagePath);
			
			
			userentity.setProfilepic(imagePath);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//db adduser method calling
		
		userDao.addUser(userentity);
		//mailservice.sendWelcomeMail(userentity.getEmail(),userentity.getFirstName());
		return "Login";
	}
	
	@GetMapping("/listuser")
	public String listUser(Model model)
	{
		List<UserEntity> users=userDao.getallUsers();
		model.addAttribute("users", users);
		return "listuser";
	}
	
	@GetMapping("/search")
	public String search()
	{
		return "SearchUser";
	}
	
	@PostMapping("searchuser")
	public String searchuser(String firstname,Model model)
	{
		List<UserEntity> users = userDao.searchbyFirstName(firstname);
		model.addAttribute("users",users);
		return "listuser";
	}
	
	@GetMapping("deleteUser")
	public String deleteuser(Integer userid)
	{
		System.out.println(userid);
		userDao.delete(userid);
		return "redirect:/listuser";
	}
	
	@GetMapping("viewUser")
	public String viewuser(Integer userid,Model model)
	{
		UserEntity users=userDao.viewuser(userid);
		model.addAttribute("users",users);
		return "ViewUser";
	}
	
	@GetMapping("edituser")
	public String editUser(Integer userid,Model model) {
		System.out.println(userid);
		UserEntity user = userDao.getByUserId(userid);
		model.addAttribute("user",user);
		return "EditUser";
	}

	@PostMapping("updateuser")
	public String updateUser(UserEntity user) {
		//firstName 
		//userId 
		
		userDao.updateUser(user);
		return "redirect:/listuser";
	}
	
	@PostMapping("authenticate")
	public String loginUser(String email,String password,Model model,HttpSession Userdata)
	{
		UserEntity user=null;
		user=userDao.getUserByEmail(email);
		
		if(user==null||!user.getPassword().equals(password))
		{
			
			model.addAttribute("error","Invalid credentials");
			return "Login";
		}
		
		Userdata.setAttribute("Userdata", user);
		return "Home";
	}
	
	
}
