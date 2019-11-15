<%@ page import="com.bean.VehicleBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update a Vehicle</title>
</head>
<body>
<%VehicleBean s=(VehicleBean) request.getAttribute("s"); %>
<form action="ActionController" method="post">
	<table>
		<tr>
			<td>Year</td>
			<td><input type="text" name="year" value="<%=s.getYear()%>"></td>
		</tr>
		<tr>
			<td>Make</td>
			<td><input type="text" name="make" value="<%=s.getMake()%>"></td>
		</tr>
		<tr>
			<td>Model</td>
			<td><input type="text" name="model" value="<%=s.getModel()%>"></td>
		</tr>
		<tr>
			<td><input type="hidden" name="id" value="<%=s.getId()%>">
			<td><br><input type="submit" name="action" value="update" ></td>
		</tr>
	</table>
<br><a href="show.jsp">Show details</a>
</form>
</body>
</html>