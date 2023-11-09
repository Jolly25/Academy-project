<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

<a href="view_matchlist">Visualizza lista dei match</a> <br>
<a href="logout">Logout</a>
<div>
<h2>Lista dei match</h2>
    <button id="buttonLoad">Load</button> &nbsp;
    <ul id="list"></ul>
    <br/><br/>
</div>

<script src=${pageContext.request.contextPath}/resources/js/admin.js></script>
</body>
</html>