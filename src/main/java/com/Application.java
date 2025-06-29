package com;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;

@SpringBootApplication
public class Application {

	public static void main(String[] args) 
	{
		SpringApplication.run(Application.class, args);
	}
	
		@Value("${cloudinary.cloud-name}")
		String cloudName;
		@Value("${cloudinary.api-key}")
		String apiKey;
		@Value("${cloudinary.api-secret}")
		String apiSecret;
		@Bean
		Cloudinary getCloudinary() 
		{
		Map<String, String> config = new HashMap<>();
		config.put("cloud_name", cloudName);
		config.put("api_key", apiKey);
		config.put("api_secret", apiSecret);
		return new Cloudinary(config);
		}			



}
