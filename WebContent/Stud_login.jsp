<%@page import="java.util.ArrayList"%>
<%@page import="java.awt.List"%>
<%@page import="java.util.*"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	The student data: ${param.firstname} ${param.lastname} Country is.
	${param.Country }
	<br /> Favorite language is ${param.favlang }
	<br />
	<ul>
		Favorite sport game is
		<%
		String[] abc = request.getParameterValues("favgame");

		if (abc != null) {
			for (String data : abc) {
				out.println("<li>" + data + "</li>");
			}
		}
	%>
	
</body>
</html>