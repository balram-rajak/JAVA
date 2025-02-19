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
			<h1>
				<% out.println("Register here"); %>
			</h1>
			</div>
			<div align="center">
		<form name="login" action="Pass" method="post">
			<br /> user name:<input type="text" name="EMP_NAME" title="EMP_NAME">
			<br /> Department:<input type="text" name="DEPT" title="DEPT">
			<br /> Project:<input type="text" name="PROJECT" title="PROJECT">		
			<br /> password: <input type="password" name="pass"> <br />
			<button name="Register" formaction="Register">register</button>
	
		</form>
	</div>
</body>
<%@ include file="footer.html"%>
</html>