<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<%@ include file="header.html"%>
</head>
<body>
	<div align="center">
		<h1 style="color: red;">User doesn't exist </h1>
		<form name="register" method="get">
			<h1>
				<% out.println("Register here"); %>
			</h1>
			<button type="submit" formaction="Registerform.html">Register</button>

		</form>
	</div>
</body>
<%@ include file="footer.html"%>
</html>