<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/homeAdmin.css type="text/css">
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark gradient-custom">
        <div class="container-fluid">
        <span class="navbar-brand" style="color: white;">Benvenuto Utente</span>
        <button type="button" class="btn btn-outline-danger" onclick="window.location.href='logout'">Logout</button>
    </div>
    </nav>
    <div class="container mt-4">
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="card mb-4">
                    <h2 class="card-title">Classifica giocatori</h2>
                    <div class="card-body scrollable-card">
                        <ul class="list-group match-list">
                            <li class="list-group-item d-flex justify-content-between align-items-center match-item">
                                Player1
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center match-item">
                                Player2
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center match-item">
                                Player3
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center match-item">
                                Player4
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center match-item">
                                Player5
                            </li>
                         </ul>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <h2 class="card-title">Allena algoritmi</h2>
                        <button class="btn btn-primary" disabled>Allena algoritmi</button>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card mb-4">
                    <h2 class="card-title">Classifica algoritmi</h2>    
                    <div class="card-body scrollable-card">
                        <ul class="list-group match-list">
                            <li class="list-group-item d-flex justify-content-between align-items-center match-item">
                                Algo1
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center match-item">
                                Algo2
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center match-item">
                                Algo3
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center match-item">
                                Algo4
                            </li>
                         </ul>    
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="card mb-4">
                    <h2 class="card-title">Elenco dei match</h2>
                    <div class="card-body scrollable-card">
                        <ul class="list-group match-list" id="matchlist">
                        </ul>
                    </div>
                <div style="padding-top: 5%;">
                <button id="buttonLoadMatch" type="button" class="btn btn-primary">Load</button> 
                </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="card border-danger mb-4 ">
                    <h2 class="card-title">Segnala un errore</h2>
                    <div class="card-body scrollable-card">
                        <ul class="list-group match-list" id="reportlist">
                            
                        </ul>
                    </div>
                    <div style="padding-top: 5%;">
                <button id="buttonLoadReport" type="button" class="btn btn-primary">Load</button> 
                </div>
                </div>
            </div>
        </div>

        <div class="card">
            <h2 class="card-title">Lista dei giocatori</h2>
            <div class="card-body scrollable-card">
                <ul class="list-group player-list">
                    <li class="list-group-item d-flex justify-content-between align-items-center player-item">
                        Nome Giocatore 1
                        <button class="btn btn-danger btn-sm ban-button">Banna</button>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center player-item">
                        Nome Giocatore 2
                        <button class="btn btn-danger btn-sm ban-button">Banna</button>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center player-item">
                        Nome Giocatore 3
                        <button class="btn btn-danger btn-sm ban-button">Banna</button>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center player-item">
                        Nome Giocatore 4
                        <button class="btn btn-danger btn-sm ban-button">Banna</button>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center player-item">
                        Nome Giocatore 5
                        <button class="btn btn-danger btn-sm ban-button">Banna</button>
                    </li>
                </ul>
            </div>
        </div>
    </div>

<a href="logout">Logout</a>
<div>
    
</div>

<script src=${pageContext.request.contextPath}/resources/js/admin.js></script>

</body>
</html>