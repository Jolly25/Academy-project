<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
		.navbar {
            margin-bottom: 50px;
        }
        .navbar-brand {
            color: #FFA07A;
            font-weight: bold;
        }
        .navbar-nav .nav-item .nav-link {
            color: #FFA07A;
        }
        .navbar-nav .nav-item .nav-link:hover {
            color: #D35400;
        }
        .btn-logout {
			position: absolute;
			top: 10px; 
			right: 10px; 
		}
		#welcome {
			font-size: 25px;
			color: rgb(37, 150, 190);
		}
		span {
			font-style: italic;
		}
    </style>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
        <a style="width: 3%;" class="navbar-brand"><img style="width: 95%;" src=${pageContext.request.contextPath}/resources/style/globe-26.gif alt="GIF animata"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <div id="welcome">Benvenuto <span>${user.username}</span>&nbsp;&nbsp;&nbsp;&nbsp;</div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="home_userr">Gioca</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ranking_list">Classifica</a>
                </li>
                <li class="nav-item">
					<button type="button" class="btn btn-outline-danger btn-logout" onclick="window.location.href='logout'" id="">Logout</button>
				</li>
            </ul>
        </div>
    </nav>

</body>
</html>