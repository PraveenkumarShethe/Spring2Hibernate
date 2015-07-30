<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Login </title>
</head>
<body>
<h1>Employee Login Form</h1>
<form action= "/sdnext/loginFrom.html" method="get">
Enter the User Name / User ID : <input type="text" name="Employee_UserName"><br> 
Enter the User Password : <input type="password" name="Employee_Userpwd"><br>
<input type="submit" value="Login"> 
</form>

<center><h3><a href="employees.html">List of Employees</a></h3>
<h3><a href="add.html">Add Employee</a></h3>
</center>
</body>
</html>