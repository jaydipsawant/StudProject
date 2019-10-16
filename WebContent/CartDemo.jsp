<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<html>
<head>
<title>Item Details</title>
</head>
<body>
	<form action="CartDemo.jsp">
		Item Name:<input type="text" name="itemName" /><br /> <input
			type="submit" value="Submit" /><br />
	</form>
	<%
		List<String> items = (List<String>) session.getAttribute("ABC");

		if (items == null) {
			items = new ArrayList<String>();
			session.setAttribute("ABC", items);
		}
		String sItem = request.getParameter("itemName");
		if (sItem != null && (!sItem.trim().equals(""))) {
			items.add(sItem);
			response.sendRedirect("CartDemo.jsp");
		}
	%>

	<b>List of Items:<b />
		<ol>
			<%
				for (String temp : items) {
					out.println("<li>" + temp + "</li>");
				}
		
			%>
		</ol>
</body>
</html>