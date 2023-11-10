<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>


	<%@ include file="Navbar.html" %>
    <div id="carousel" class="carousel slide" data-ride="carousel">
        <ul class="carousel-indicators">
            <li data-target="#carousel" data-slide-to="0" class="active"></li>
            <li data-target="#carousel" data-slide-to="1"></li>
            <li data-target="#carousel" data-slide-to="2"></li>
        </ul>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://cdn.countryflags.com/thumbs/italy/flag-800.png" alt="Italy" width="100%">
            </div>
            <div class="carousel-item">
                <img src="https://cdn.countryflags.com/thumbs/france/flag-800.png" alt="France" width="100%">
            </div>
            <div class="carousel-item">
                <img src="https://cdn.countryflags.com/thumbs/germany/flag-800.png" alt="Germany" width="100%">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carousel" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#carousel" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>
</body>
</html>