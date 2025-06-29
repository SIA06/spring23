package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.entity.ProductEntity;

@Repository
public class ProductDao 
{

	@Autowired
	JdbcTemplate smt;
	
	public void addproduct(ProductEntity product)
	{
		smt.update("insert into product(productname,price,qty) values(?,?,?)",product.getProductname(),product.getPrice(),product.getQty());
	}
	
	public List<ProductEntity> listproducts()
	{
		List<ProductEntity> products=smt.query("select * from product",new BeanPropertyRowMapper<>(ProductEntity.class));
		return products;
	}
	
	public List<ProductEntity> searchproduct(String productname)
	{
		List<ProductEntity> products;
		if(productname.length()==1)
		{
			products=smt.query("select * from product where productname like ?", new BeanPropertyRowMapper<>(ProductEntity.class),productname+'%');
		}
		else
		{
			products=smt.query("select * from product where productname= ?", new BeanPropertyRowMapper<>(ProductEntity.class),productname);
		}
		return products;
	}
	
}
