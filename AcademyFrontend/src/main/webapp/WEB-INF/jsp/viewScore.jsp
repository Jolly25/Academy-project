<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Score</title>
<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/viewScore.css type="text/css">
</head>
<body>

<p id="output">Hai indovinato ${r.score} bandiere su ${r.bandiereViste}</p>

<a href="logout" id="logout">Logout</a>

</body>
</html>