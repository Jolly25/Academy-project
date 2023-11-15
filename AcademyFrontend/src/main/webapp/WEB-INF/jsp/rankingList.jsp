<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href=${pageContext.request.contextPath}/resources/style/rankingList.css type="text/css">
    <script src=${pageContext.request.contextPath}/resources/js/rankingList.js></script>
<title>Classifica Giocatori</title>
</head>
<body>
                <div class="title-and-load">
                    <h2 class="card-title">Classifica giocatori</h2>
                    <button id="buttonLoadRanking" type="button" class="btn btn-primary load-btn">&#8635;</button> 
                </div>
                    <div class="card-body scrollable-card">
                        <ul class="list-group match-list" id="ranking">
                        
                         </ul>
                    </div>

</body>
</html>