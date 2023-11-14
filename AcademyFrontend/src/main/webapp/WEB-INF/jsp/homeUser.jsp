	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Home</title>
	<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/homeUser.css type="text/css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css">
	
	</head>
	<header>
		<%@ include file="Navbar.html" %>
	</header>
	<body>

	


	<button class="glow-on-hover" type="button" onclick="window.location.href='start_game'" style="font-size: medium;">PLAY!</button>
	
	</body>
	</html>