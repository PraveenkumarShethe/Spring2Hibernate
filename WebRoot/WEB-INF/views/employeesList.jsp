<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Employees</title>
</head>
<body>
<h1>List of Plank  Employees</h1>
<h2><a href="add.html">Add More Employee</a></h2>
<h2><a href="employees.html">List of Employees</a></h2>
<c:if test="${!empty employees}">
	<table align="left" border="1">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Password</th>
			<th>Employee Age</th>
			<th>Employee Salary</th>
			<th>Employee Address</th>
		</tr>

		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.id}"/></td>
				<td><c:out value="${employee.name}"/></td>
				<th><c:out value="${employee.pwd}"/></th>
				<td><c:out value="${employee.age}"/></td>
				<td><c:out value="${employee.salary}"/></td>
				<td><c:out value="${employee.address}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>