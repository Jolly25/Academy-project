<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Guess the Country Flag</title>
    <link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/game.css type="text/css">
</head>
<body>
    <h1>Indovina la bandiera!</h1>
    <div id="country-container">
        <img class="flag" id="flagImage" src="">
        
        <form method="post" action="checkstring_prova" id="checkstring_form">
	        <input type="text" id="userInput" name="input" placeholder="Inserisci il nome del Paese">
	        <button type="submit">CheckString</button>
        </form>
        
        <button id="confirmButton">Indovina!</button>
        
    </div>
    <a  style="color:white;" href="logout">Logout</a>
    
	<form hidden method="POST" action="score" id="partitaFinitaForm">
		<input id="partitaFinitaInput" name="partitaFinitaInput">
	</form>

	<script src=${pageContext.request.contextPath}/resources/js/game.js param1=${partita} ></script>
</body>
</html>
