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
	<h2>List</h2>
	<a href="searchproduct">Search</a>
	<table border="2px">
		
		<tr>
			<th>Product Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Qty</th>
		</tr>
		<c:forEach items="${products}" var="p">
		<tr>
			<td>${p.pid}</td>
			<td>${p.productname}</td>
			<td>${p.price}</td>
			<td>${p.qty}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>