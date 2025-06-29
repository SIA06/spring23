package com.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookEntity 
{
	@NotBlank(message="Please enter book name")
	@Pattern(regexp="[a-zA-Z\\s]+",message="Please enter valid book name")
	String name;
	
	@NotNull(message="Please enter price")
	@Min(value=1,message="enter price>1")
	@Max(value=5000000,message="price can't be <500000")
	Integer price;
	
	@NotBlank(message="Please enter category")
	@Pattern(regexp="[a-zA-Z\\s]+",message="Please enter valid category")
	String category;
	
	@NotNull(message="Please enter tax")
	Integer tax;
}
