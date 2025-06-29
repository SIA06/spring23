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
<h2>List User</h2>
<a href="search">Search</a>
<table border="2px">
	<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>Password</th>
			<th>Action</th>
	</tr>
	<c:forEach items="${users}" var="u">
	<tr>
				<td>${u.id}</td>
				<td>${u.firstName}</td>
				<td>${u.email}</td>
				<td>${u.password}</td>
				<td>
					<a href="deleteUser?userid=${u.id}">Delete</a>
					<a href="viewUser?userid=${u.id}">View User</a>
					<a href="edituser?userid=${u.id}">Edit</a>
				</td>
	</tr>
</c:forEach>

</table>
</body>
</html>