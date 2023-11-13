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
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>


<div class="container">
    <div class="row">
        <div class="col-lg">
            <p id="output">Hai indovinato ${r.score} bandiere su ${r.bandiereViste}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-lg">
            <button class="flagButton" id="restartButton" type="button" onclick="window.location.href='home_userr'">Ricomincia</button>
        </div>
    </div>
</div>


<button type="button" class="btn btn-outline-danger btn-logout" onclick="window.location.href='logout'" id="logout">Logout</button>

<!-- Modale per risposta corretta -->
		<div id="correctModal">
		  Risposta corretta! <br>
		  <span id="matchedWord"></span> <br>
		  <button id="reportButton" type="button" class="flagButton">Segnala</button>
		</div>
		
			
		<!-- Modale per risposta errata -->
		<div id="wrongModal">
		  Risposta errata! <br>
		  <span id="matchGot"></span> <br>
		  <span id="correctAnswer"></span> <br>
		  <button id="reportBtn" type="button" class="flagButton">Segnala</button>
		</div>

<div hidden>
	<p id="flag">${flag}</p>
	<p id="previousFlag">${previousFlag}</p>
	<p id="previousMatch">${previousMatch}</p>
	<p id="previousInput">${previousInput}</p>
</div>

<script src=${pageContext.request.contextPath}/resources/js/score.js></script>
</body>
</html>