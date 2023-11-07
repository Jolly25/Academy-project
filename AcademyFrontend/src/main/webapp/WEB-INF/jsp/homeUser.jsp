<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/homeUser.css type="text/css">
</head>
<body>

<form action="game">
    <input type="submit" value="Play" id="play_btn"/>
</form>

<a href="logout" id="logout">Logout</a>

</body>
</html>