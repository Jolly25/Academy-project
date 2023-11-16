<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/rankingList.css type="text/css">
	<title>Classifica Giocatori</title>
    <meta charset="ISO-8859-1">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
	<header>
		<%@ include file="navbar.jsp" %>
	</header>
<body>

<div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
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
        </div>
  </div>
                    

    <script src=${pageContext.request.contextPath}/resources/js/rankingList.js></script>
</body>
</html>