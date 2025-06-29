<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="getbook" method="post">
	BOOK NAME: <input type="text" name="name" value="${book.name}"/>
	${result.getFieldError("name").getDefaultMessage()}
	<br><br>
	PRICE:     <input type="text" name="price" value="${book.price}"/>
	${result.getFieldError("price").getDefaultMessage()}
	<br><br>
	CATEGORY:  <input type="text" name="category" value="${book.category}"/>
	${result.getFieldError("category").getDefaultMessage()}
	<br><br>
	TAX:       <input type="text" name="tax" value="${book.tax}"/>
	${result.getFieldError("tax").getDefaultMessage()}
	<br><br>
	<input type="submit" value="add"/>
</form>
</body>
</html>