<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Login</title>
<%@ include file="header.html"%>
</head>
<% //java.lang.System.out.println("youportal");
%>
<body>
	<div align="center">
		<h1>
			<% out.println("Welcome "); 
			
			%>
			${username} Wiproite
		</h1>
		
	</div>
</body>

<%@ include file="footer.html"%>
<%= new java.util.Date() %>
</html>