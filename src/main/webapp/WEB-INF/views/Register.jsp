<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>SignUp</h2>
<form  action="saveuser" method="post" enctype="multipart/form-data">

	First Name:<input type="text" name="firstName"/><br><br>
	Email:<input type="email" name="email"/><br><br>
	Password:<input type="password" name="password"/><br><br>
	Profile Picture:<input type="file" name="ProfilePic"/><br><br>
	<input type="submit" value="SignUp"/>
</form>
<a href="login">Existing user?</a>
</body>
</html>