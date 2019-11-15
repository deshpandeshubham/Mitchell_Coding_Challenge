<%@page import="com.bean.VehicleBean" %>
<%@page import="com.dao.VehicleDao" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Automobile Management System</title>
</head>
<body>
<%List<VehicleBean> list=VehicleDao.getAllVehicles();
%>
<table border="1" width="100%" cellpadding=5 cellspacing=5>
	<tr>
		<th>ID</th>
		<th>YEAR</th>
		<th>MAKE</th>
		<th>MODEL</th>
		<th>EDIT</th>
		<th>DELETE</th>
	</tr>
<% for(VehicleBean s:list) {
%>
<tr>
		<td><%=s.getId() %></td>
		<td><%=s.getYear() %></td>
		<td><%=s.getMake() %></td>
		<td><%=s.getModel() %></td>
	<td>
		<form action="ActionController" method="post">
			<input type="hidden" name="id" value="<%=s.getId()%>">
			<input type="submit" name="action" value="edit">
		</form>
	</td>
	<td>
		<form action="ActionController" method="post">
			<input type="hidden" name="id" value="<%=s.getId()%>">
			<input type="submit" name="action" value="delete">
		</form>
	</td>
</tr>
<% } 
%>
</table>
<br><a href="index.jsp">Insert again</a>
</body>
</html>