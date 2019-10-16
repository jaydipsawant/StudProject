<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resp_load</title>
</head>
<body>
<% 
request.getParameter("name");
request.getParameter("selecttab");
request.getParameter("city");
String[] str =request.getParameterValues("brand");
%>
${param.name}
${param.selecttab}
${param.city}
${param.brand}

<%

	out.println(Arrays.toString(str)); 	

%>
</body>
</html>