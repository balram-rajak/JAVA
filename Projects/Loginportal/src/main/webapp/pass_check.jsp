<%@page import="javax.swing.text.html.HTML"%>
<%@page import="javax.print.attribute.standard.PrinterMakeAndModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>password check</title>
</head>
<body>
	<% 
String user=request.getParameter("username");
String pass=request.getParameter("pass");

class user{
	String username;
	String pass;
	
	
	}
user u1=new user();
u1.pass=pass;
if(pass_check(u1.pass)==true)
	out.println("<HTML><h1>successfully logined</h1></HTML>");



%>
	<%!

boolean pass_check(String s){
	if(s.equals("balram")){
		System.out.println("<HTML><h1>successfully logined</h1></HTML>");
		return true;
	
	}
	
	else{
		return false;
		}
}

%>
</body>
</html>