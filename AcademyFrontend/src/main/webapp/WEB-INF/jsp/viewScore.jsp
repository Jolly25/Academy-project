<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Score</title>
	<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/viewScore.css type="text/css">
	<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/game2.css type="text/css">
	<script src="https://d3js.org/d3.v7.min.js"></script>
</head>
<body>

<p id="output">Hai indovinato ${r.score} bandiere su ${r.bandiereViste}</p>

<form method="get" action="home_userr" id="restart_form">
	<button class="flagButton" id="restartButton" type="submit">Ricomincia</button>
</form>

<a href="logout" id="logout">Logout</a>

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

<script src=${pageContext.request.contextPath}/resources/js/score.js param1=${flag} param4=${previousFlag} param2=${previousMatch} param3=${previousInput}></script>
</body>
</html>