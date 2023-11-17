<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
	table, th, td{
		border: 1px solid;
		border-collapse: collapse;
	}
	td, th{
		padding: 10px;
	}
</style>
<meta charset="ISO-8859-1">
<title>Match List</title>
</head>
<body >

<table>
	<tr>
		<th>Input
		<th>StandardWord
		<th>Algorithm
		<th>Confirm
	</tr>
	<c:forEach var="m" items="${lista}">
    	<tr>
    		<td>${m.input}
    		<td>${m.standardword}
    		<td>${m.algorithm}
    		<td>${m.confirm}
    	</tr>
	</c:forEach>
</table>




</body>
</html>
