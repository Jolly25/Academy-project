<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            $(document).on("click", "#buttonLoad", function() {
                $.get("matchlist", function(responseJson) {
                    var $form = $("#list");
                    $form.find("label").remove();
                    $form.find("input").remove(); 
                    $.each(responseJson, function(index, match) {
                        $("<label>").val(match.id).text(match.input + " ").appendTo($form);
                        $("<label>").val(match.id).text(match.standardword).appendTo($form); 
                        $("<br>").appendTo($form);
                        
                    });                   
                });
            });
             
            $(document).on("click", "#buttonSubmit", function() {
                var params = {category : $("#dropdownlist option:selected").text()};
                $.post("matchlist", $.param(params), function(responseText) {
                    alert(responseText);                   
                });
            });
        </script>

</head>
<body>

<a href="view_matchlist">Visualizza lista dei match</a> <br>
<a href="logout">Logout</a>
<div>
<h2>Dynamic Drop Down List (AJAX) Demo</h2>
    <button id="buttonLoad">Load</button> &nbsp;
    <form id="list"></form>
    <br/><br/>
    <button id="buttonSubmit">Submit</button>
</div>
</body>
</html>