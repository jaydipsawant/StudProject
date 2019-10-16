<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="java.util.*, com.serv.mvc2.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<link type="text/css" rel="stylesheet" href="CSS/style.css">
<link type="text/css" rel="stylesheet" href="CSS/add-student-style.css">
<title>Student Tracker App</title>
</head>
<%
	// get the students from the request object (sent by servlet)
	List<Student> theStudents = (List<Student>) request.getAttribute("STUD_LIST");
%>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Pune University</h2>
		</div>
	</div>
	<div id="container">

		<div id="content">

			<button type="button"
				onclick="window.location.href='./Ex5-StudentApp/Add-stud-form.jsp'; return false;"
				class="add-student-button">Add Record</button>

			<table>


				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<c:forEach var="temop" items="${STUD_LIST}">

					<c:url var="tempoperation" value="./StudentControllerServlet">
						<c:param name="command" value="LOAD"></c:param>s
					<c:param name="studId" value="${temop.id}"></c:param>
					</c:url>

					<c:url var="deleteoperation" value="./StudentControllerServlet">
						<c:param name="command" value="DELETE"></c:param>s
					<c:param name="studId" value="${temop.id}"></c:param>
					</c:url>

					<tr>
						<td>${temop.id}</td>
						<td>${temop.firstname}</td>
						<td>${temop.lastname}</td>
						<td>${temop.email}</td>
						<td><a href="${tempoperation}">Update</a>
						|
						<a href="${deleteoperation}" onclick="if(!(confirm('sure u want to delete thid record?'))) return false"> Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>


</html>








