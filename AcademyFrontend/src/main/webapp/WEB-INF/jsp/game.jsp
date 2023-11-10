<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Guess the Country Flag</title>
    <link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/game2.css type="text/css">
    <script src="https://d3js.org/d3.v7.min.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body style="height: 100%;">

	<h1 id="title">Indovina la bandiera!</h1>
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
				        <p id="error"></p>
				        <button type="submit" id="indovina" class="flagButton">Indovina</button>
		        	</form>
			     
			      <div class="col-md-6">
			     
			        <form method="get" action="restart" id="restart_form"></form>
		        	<button class="flagButton" id="restartButton" onclick="showConfirmationModal()">Ricomincia</button>
			        
			      </div>
			  </div>
			</div>
			
		<!-- Modale per risposta corretta -->
		<div id="correctModal">
		  Risposta corretta! <br>
		  <span id="matchedWord"></span>
		  <button id="reportButton" type="button" class="flagButton">Segnala</button>
		</div>
		
		<!-- Modale per risposta errata -->
		<div id="wrongModal">
		  Risposta errata! <br>
		  <span id="correctAnswer"></span>
		  <button id="reportBtn" type="button" class="flagButton">Segnala</button>
		</div>

		<div id="restartModal">
		  <div class="modal-content">
		    <p>Cliccando OK ricomincerai la partita</p>
		    <button id="confirmRestart">OK</button>
		    <button id="cancelRestart">Annulla</button>
		  </div>
		</div>
		
		
	</div>
	
	<a href="logout" id="logout">Logout</a>
	
	<div hidden>
		<p id="flag">${flag}</p>
		<p id="cca2">${cca2}</p>
		<p id="previousFlag">${previousFlag}</p>
		<p id="previousMatch">${previousMatch}</p>
		<p id="previousInput">${previousInput}</p>
	</div>

	<script src=${pageContext.request.contextPath}/resources/js/game.js></script>
	<script src=${pageContext.request.contextPath}/resources/js/inputValidation.js></script>
</body>
</html>
