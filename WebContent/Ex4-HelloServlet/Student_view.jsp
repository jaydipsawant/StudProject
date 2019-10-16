<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Data View</title>
</head>
<body>
	<table border="1">
		<tr>
		<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email-Address</th>
		</tr>
		<c:forEach var="tempstuddata" items="${Student_Data}">

			<tr>
			<td>${tempstuddata.id}</td>
				<td>${tempstuddata.firstname}</td>
				<td>${tempstuddata.lastname}</td>
				<td>${tempstuddata.email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>