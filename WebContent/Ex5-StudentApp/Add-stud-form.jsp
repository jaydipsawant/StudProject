<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link type="text/css" rel="stylesheet" href="CSS/style.css">
	<link type="text/css" rel="stylesheet" href="CSS/add-student-style.css">	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student Record</title>
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h1>Pune University</h1>
		</div>
	</div>
	
	<div id="container">
	<h3>Add Student</h3>
	<form action="../StudentControllerServlet">
		<input type="hidden" name="command" value="ADD">
		<table>
			<tbody>
				<tr>
					<td><label>ID</label></td>
					<td><input type="text" name="id" /></td>
				</tr>
				<tr>
					<td><label>First Name</label></td>
					<td><input type="text" name="firstname" /></td>
				</tr>
				<tr>
					<td><label>Last Name</label></td>
					<td><input type="text" name="lastname" /></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="Submit" value="Save" class="save" /></td>
				</tr>
			</tbody>
		</table>
	</form>
	<div style="clear: both;"></div>
	<a href="../StudentControllerServlet">Back to List</a>
	</div>
</body>
</html>