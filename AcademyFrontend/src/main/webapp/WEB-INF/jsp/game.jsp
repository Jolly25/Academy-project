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
        
		
        
        
        ${match}
        
        ${flag}
        
        <form method="post" action="turno">
        	<button id="confirmButton" type="submit">Indovina!</button>
        </form>
        
        
    </div>
    <a  style="color:white;" href="logout">Logout</a>

	<script src=${pageContext.request.contextPath}/resources/js/game.js param1=${flag} param2=${match}></script>
</body>
</html>
