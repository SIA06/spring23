package com.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity 
{
	private Integer id;
	private String firstName;
	private String email;
	private String password;
	private String profilepic;
	
	
	
}
