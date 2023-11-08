<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Guess the Country Flag</title>
    <link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/game2.css type="text/css">
    <script src="https://d3js.org/d3.v7.min.js"></script>
</head>
<body>

	<h1>Indovina la bandiera!</h1>
		<div id="overlay"></div>
			<div id="country-container">
			  <div class="row"></div>
			  <div class="col-md-6">
			    <div class="d-flex justify-content-between align-items-center">
			     <img class="flag" id="flagImage" src="">
			     <div id="timer" class="container"></div>
			      <div id="counter-container">
			        <span id="mainText">Bandiere indovinate: ${score}</span> 
			      </div>
			      <br>
			      
				    <!--<input type="text" id="userInput" placeholder="Inserisci il nome del Paese">  -->
				    <form method="post" action="turno" id="indovina_form">
				        <input type="text" id="userInput" name="input" placeholder="Inserisci il nome del Paese">
				        <button type="submit" id="indovina" class="flagButton">Indovina</button>
		        	</form>
			     
			      <div class="col-md-6">
			     
			        
			        <button class="flagButton" id="restartButton" onclick="showConfirmationModal()">Ricomincia</button>
			      </div>
			  </div>
			</div>
			
		<!-- Modale per risposta corretta -->
		<div id="correctModal">
		  Risposta corretta! <br>
		  <span id="matchedWord"></span>
		  <button id="reportButton" class="flagButton">Segnala</button>
		</div>
		
		<!-- Modale per risposta errata -->
		<div id="wrongModal">
		  Risposta errata! <br>
		  <span id="correctAnswer"></span>
		  <button id="reportButton" class="flagButton">Segnala</button>
		</div>
		
		<div id="gameResultModal" class="modal">
		  <span class="close" id="closeGameResultModal">&times;</span>
		  <p id="gameResultMessage"></p>
		</div>
	</div>
	
	<a href="logout" id="logout">Logout</a>

	<script src=${pageContext.request.contextPath}/resources/js/game.js param1=${flag} param4=${previousFlag} param2=${previousMatch} param3=${previousInput}></script>
</body>
</html>
