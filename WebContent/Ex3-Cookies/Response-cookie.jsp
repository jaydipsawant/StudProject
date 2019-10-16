<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response to cookies</title>
</head>
<%
	String name=request.getParameter("langsel");
	Cookie cooki = new Cookie("firstcheck",name);
	cooki.setMaxAge(60*60*24*3650);
	response.addCookie(cooki);
%>
<body>
The name of the cookies is ${param.langsel}

<br/>
<a href="homepage.jsp" >Return to home</a>
</body>
</html>