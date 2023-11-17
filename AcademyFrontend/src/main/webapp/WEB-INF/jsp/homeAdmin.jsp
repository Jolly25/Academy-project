<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/homeAdmin.css type="text/css">
	<script src=${pageContext.request.contextPath}/resources/js/admin.js></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark gradient-custom">
        <div class="container-fluid">
        <span class="navbar-brand" style="color: white;">Benvenuto&nbsp;${user.username}</span>
        <button type="button" class="btn btn-outline-danger" onclick="window.location.href='logout'">Logout</button>
    </div>
    </nav>
	    <div class="container mt-6">
	        <div class="row">
	            <div class="col-lg-6 col-md-6">
	                <div class="card mb-4">
                <div class="title-and-load">
                    <h2 class="card-title">Classifica giocatori</h2>
                    <button id="buttonLoadRanking" type="button" class="btn btn-primary load-btn">&#8635;</button> 
                </div>
                    <div class="card-body scrollable-card">
                        <ul class="list-group match-list" id="ranking">
                        </ul>
                    </div>
                </div>
            </div>
            
            <div class="col-lg-6 col-md-6">
                <div class="card mb-4">
                    <div class="title-and-load">
	                    <h2 class="card-title">Classifica algoritmi</h2>
	                    <button id="buttonLoadAlgorithm" type="button" class="btn btn-primary load-btn">&#8635;</button>  
                    </div>
                    <div class="card-body scrollable-card">
                        <ul class="list-group match-list" id="algorithm">
                        
                         </ul>    
                    </div>
                </div>
            </div>
            </div>
            
            <div class="row">
            <div class="col-lg-9">
                <div class="card mb-4">
                <div class="title-and-load">
                    <h2 class="card-title">Elenco dei match</h2>
                    <button id="buttonLoadMatch" type="button" class="btn btn-primary load-btn">&#8635;</button> 
                </div>
                    <div class="card-body scrollable-card">
                        <ul class="list-group match-list" id="matchlist">
                        </ul>
                    </div>
                <div style="padding-top: 5%;">
                </div>
                </div>
            </div>
            
            <div class="col-lg-3">
                <div class="card mb-4 ">
                <div class="title-and-load">
                    <h2 class="card-title">Lista dei giocatori</h2>
                    <button id="buttonLoadPlayers" type="button" class="btn btn-primary load-btn">&#8635;</button> 
                </div>
                    <div class="card-body scrollable-card">
                        <ul class="list-group match-list" id="playerlist">
                            
                        </ul>
                    </div>
                    <div style="padding-top: 5%;">
                </div>
                </div>
            </div>
        </div>
        
        
		<div class="row">
			<div class="col-lg-3">
                <div class="card mb-4">
                <div class="title-and-load">
                    <h2 class="card-title">Allena algoritmi</h2>
                </div>
                    <div class="card-body trainalgo">
                        <button class="btn btn-primary" id="trainAlgoBtn">Allena algoritmi</button>
                        <br>
                        <div>&nbsp;</div> <br>
                        <div id="trainMessage"></div>
                        
                    </div>
                </div>
            </div>

        <div class="col-lg-9">
		<div class="card border-danger">
        <div class="title-and-load">
            <h2 class="card-title">Segnalazioni</h2>
            <button id="buttonLoadReport" type="button" class="btn btn-primary load-btn">&#8635;</button> 
        </div>  
            <div class="card-body scrollable-card">
                <ul class="list-group player-list" id="reportlist">
                </ul>
            </div>
            </div>
        </div>
        </div>
        
</div>


<div class="modal fade" id="matchModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal a tutto schermo con Input</h5>
      </div>
      <div class="modal-body">
        <div class="form-group">
          <span id="inputMatch"></span>
          <input type="text" class="form-control" id="inputText" list="parole" autocomplete="off">
          <datalist id="parole">
            <option value="">
          </datalist>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" id="closeButton" data-dismiss="modal">Annulla</button>
        <button type="button" class="btn btn-primary" id="modalMatchConfirm">Conferma</button>
      </div>
    </div>
  </div>
</div>
	
</body>
</html>