package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.UserEntity;

@Repository
public class userDao 
{
	@Autowired
	JdbcTemplate stmt;
	
	public void addUser(UserEntity user)
	{
		stmt.update("insert into users(firstname,email,password,profilepic) values(?,?,?,?)",
				user.getFirstName(),user.getEmail(),user.getPassword(),user.getProfilepic());
	}
	
	public List<UserEntity> getallUsers()
	{
		
		List<UserEntity> users=stmt.query("select * from users", new BeanPropertyRowMapper<>(UserEntity.class));
		return users;
	}
	
	public  List<UserEntity> searchbyFirstName(String firstname)
	{
		List<UserEntity> users;
		if(firstname.length()==1)
		{
			users=stmt.query("select * from users where firstname like ?", new BeanPropertyRowMapper<>(UserEntity.class),firstname+'%');
		}
		else
		{
			users=stmt.query("select * from users where firstname= ?", new BeanPropertyRowMapper<>(UserEntity.class),firstname);
		}
		return users;
	}
	
	public void delete(Integer id)
	{
		stmt.update("delete from users where id= ?",id);
	}
	
	public UserEntity viewuser(Integer id)
	{
		UserEntity users=null;
		try 
		{
			users=stmt.queryForObject("select * from users where id= ?",new BeanPropertyRowMapper<>(UserEntity.class),id);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return users;
	}
	
	public UserEntity getByUserId(Integer id) {
		UserEntity user = null;
		try {
			user = stmt.queryForObject("select * from users where id = ? ",
					new BeanPropertyRowMapper<>(UserEntity.class), id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public void updateUser(UserEntity user) {
		stmt.update("update users set firstname = ? where id = ? ", user.getFirstName(), user.getId());
	}
	
	public UserEntity getUserByEmail(String email) {
		UserEntity user = null;
		try 
		{
			user = stmt.queryForObject("select * from users where email = ? ",
					new BeanPropertyRowMapper<>(UserEntity.class), email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
