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
        <input type="text" id="userInput" placeholder="Inserisci il nome del Paese">
        <button id="confirmButton">Indovina!</button>
    </div>
    
    <p hidden id="array">${array}</p>

	<script src=${pageContext.request.contextPath}/resources/js/game.js></script>
</body>
</html>
