<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Automobile Management System</title>
<script type="text/javascript">
	function checkMake(){
		var val=document.validation.make.value;
		if(val.trim()==""){
			document.getElementById("vmake").innerHTML="Make cannot be null";
		}
		else{
			document.getElementById("vmake").innerHTML="";
		}
	}
	
	function checkModel(){
		var val=document.validation.model.value;
		if(val.trim()==""){
			document.getElementById("vmodel").innerHTML="Model cannot be null";
		}
		else {
			document.getElementById("vmodel").innerHTML="";
		}
	}
	
	function checkYear() {
		var val = document.validation.year.value;
		if(!(val >= 1950 && val <= 2050)) {
			document.getElementById("vyear").innerHTML="Year must be between 1950 and 2050";
		}
		else {
			document.getElementById("vyear").innerHTML="";
		}
	}
</script>
</head>
<body>
<form action="ActionController" method="post" name="validation">
	<table>
		<tr>
			<td>Year</td>
			<td><input type="text" name="year" onblur="checkYear();"></td>
			<td><span id="vyear"></span></td>
		</tr>
		<tr>
			<td>Make</td>
			<td><input type="text" name="make" onblur="checkMake();"></td>
			<td><span id="vmake"></span></td>
		</tr>
		<tr>
			<td>Model</td>
			<td><input type="text" name="model" onblur="checkModel();"></td>
			<td><span id="vmodel"></span></td>
		</tr>
		<tr>
			<td><br><input type="submit" name="action" value="Insert" ></td>
		</tr>
	</table>
</form>
<br><a href="show.jsp">Show Vehicle Details</a>
</body>
</html>