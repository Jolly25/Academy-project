	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Home</title>
	<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/homeUser.css type="text/css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css">
	<style>
	.btn-size {
	  font-size: medium;
	  margin-bottom: 9%;
	}
	</style>
	
	</head>
	<header>
		<%@ include file="Navbar.html" %>
	</header>
	<body>
	
	<div class="container">
	  <div class="row justify-content-center">
	    <div class="col-lg-12">
	      <div class="row justify-content-center">
	        <div class="col-md-4">
	          <button class="glow-on-hover btn-size" type="button" onclick="window.location.href='start_gameEasy'">FACILE!</button>
	        </div>
	      </div>
	      <div class="row justify-content-center">
	        <div class="col-md-4">
	          <button class="glow-on-hover btn-size" type="button" onclick="window.location.href='start_gameMid'">MEDIO!</button>
	        </div>
	      </div>
	      <div class="row justify-content-center">
	        <div class="col-md-4">
	          <button class="glow-on-hover btn-size" type="button" onclick="window.location.href='start_gameHard'">DIFFICILE!</button>
	        </div>
	      </div>
	    </div>
	  </div>
	</div>


	
</body>
</html>