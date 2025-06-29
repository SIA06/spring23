<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>User Info</h2>
<table border="2px">
	<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>Password</th>
	</tr>
	
	
	<tr>
		
		<td>${users.id}</td>
		<td>${users.firstName}</td>
		<td>${users.email}</td>
		<td>${users.password}</td>
		
	</tr>
	
</table>
</body>
</html>