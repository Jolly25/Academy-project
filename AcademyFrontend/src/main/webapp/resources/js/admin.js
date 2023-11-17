window.addEventListener('load', function() {
	loadMatchList();
	loadReportList();
	loadRanking();
	loadPlayerList();
	loadAlgorithm();
	loadStandardWords();
});

// Verifica se l'oggetto JSON è vuoto
function isJsonEmpty(jsonObject) {
  for (var key in jsonObject) {
    if (jsonObject.hasOwnProperty(key)) {
      return false; // Se ha almeno una proprietà, l'oggetto non è vuoto
    }
  }
  return true; // Se non ha nessuna proprietà, l'oggetto è vuoto
}

var loadMatchList = function() {
    $.get("matchlist", function(responseJson) {
        var $ul = $("#matchlist"); 
        $ul.find("li").remove();
        if(isJsonEmpty(responseJson))
        {
			var $li = $("<li>").val("nullo").text("Nessun Match da Confermare").appendTo($ul);
            $li.addClass('list-group-item d-flex justify-content-between align-items-center match-item');
		}
        $.each(responseJson, function(index, match) {
            var $li = $("<li>").html(match.input + "  &rarr;  " + match.standardword).appendTo($ul);
            $li.addClass('list-group-item d-flex justify-content-between align-items-center match-item');
            var $button1 = $("<button>").val(match.id + "ba").text("Conferma").appendTo($li);
            $button1.addClass('btn btn-success btn-sm accept-button tablebtn');
            $button1.click(function() {
			   var param = {matchid : match.id};
               $.post("checkmatch",  $.param(param));
               $li.remove();
               });
               
            var $button3 = $("<button>").text("Correggi").appendTo($li);
             $button3.addClass('btn btn-success incredibili btn-sm modify-button tablebtn');
            	$button3.click(function() {
				showConfirmationModalForMatch(match.input);
			});
               
            var $button2 = $("<button>").text("Elimina").appendTo($li);
            $button2.addClass('btn btn-danger btn-sm reject-button ');
            $button2.click(function() {
			   var param = {matchid : match.id};
               $.post("removematch", $.param(param));
               $li.remove();
               });	
        });                   
    });
}


$(document).on("click", "#buttonLoadMatch", loadMatchList);


var loadReportList = function() {
    $.get("reportlist", function(responseJson) {
        var $ul = $("#reportlist"); 
        $ul.find("li").remove();
        if(isJsonEmpty(responseJson))
        {
			var $li = $("<li>").val("nullo").text("Nessuna Segnalazione Presente").appendTo($ul);
            $li.addClass('list-group-item d-flex justify-content-between align-items-center match-item');
		}
        $.each(responseJson, function(index, segnalazione) {
			console.log(segnalazione.match.input);
            var $li = $("<li>").val(segnalazione.id).html(segnalazione.match.input + " " + "&rarr;" +"  " + segnalazione.match.standardword + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Creata da: " + segnalazione.idUser.username).appendTo($ul);
            $li.addClass('list-group-item d-flex justify-content-between align-items-center match-item');
            var $button1 = $("<button>").val(segnalazione.id + "ba").text("Rimuovi").appendTo($li);
            $button1.addClass('btn btn-warning btn-sm accept-button tablebtn');
            $button1.click(function() {
			   var param = {reportid : segnalazione.id};
               $.post("approvasegnalazione",  $.param(param));
               $li.remove();
               });
            var $button3 = $("<button>").val(segnalazione.id + "ba").text("Correggi").appendTo($li);
             $button3.addClass('btn btn-success incredibili btn-sm modify-button tablebtn');
			 
			$button3.click(function() {
				showConfirmationModalForReport(segnalazione.match.input, segnalazione.id);
			});
             
            var $button2 = $("<button>").val(segnalazione.id + "br").text("Ignora").appendTo($li);
            $button2.addClass('btn btn-danger btn-sm reject-button ');
            $button2.click(function() {
			   var param = {reportid : segnalazione.id};
               $.post("removesegnalazione", $.param(param));
               $li.remove();
               });	
        });                   
    });
}

$(document).on("click", "#buttonLoadReport", loadReportList);


var loadRanking = function() {
	var i = 1;
	$.get("ranking", function(responseJson) {
		var $ul = $("#ranking");
		$ul.find("li").remove();
		if(isJsonEmpty(responseJson))
        {
			var $li = $("<li>").val("nullo").text("Nessun Giocatore Presente").appendTo($ul);
            $li.addClass('list-group-item d-flex justify-content-between align-items-center match-item');
		}
		$.each(responseJson, function(index, user) {
			console.log(user.score);
			var $li = $("<li>").text(i + ". " + user.username).appendTo($ul);
			i++;
			$li.addClass("list-group-item d-flex justify-content-between align-items-center match-item");
			var $div = $("<div>").text(user.score + "%").appendTo($li);
		})
	})
}

$(document).on("click", "#buttonLoadRanking", loadRanking); 

var loadPlayerList = function() {
    $.get("users", function(responseJson) {
        var $ul = $("#playerlist"); 
        $ul.find("li").remove();
        if(isJsonEmpty(responseJson))
        {
			var $li = $("<li>").val("nullo").text("Nessun Giocatore Presente").appendTo($ul);
            $li.addClass('list-group-item d-flex justify-content-between align-items-center match-item');
		}
		else{
	        $.each(responseJson, function(index, user) {
				console.log(user.id);
	            var $li = $("<li>").val(user.id).text(user.username).appendTo($ul);
	            $li.addClass('list-group-item d-flex justify-content-between align-items-center match-item');
	            var $button2 = $("<button>").val(user.id + "br").text("Banna").appendTo($li);
	            $button2.addClass('btn btn-danger btn-sm reject-button');
	            $button2.click(function() {
				   var param = {playerId : user.id};
	               $.post("banPlayer", $.param(param));
	               $li.remove();
	               });	
	        }); 
        }                  
    });
}

$(document).on("click", "#buttonLoadPlayers", loadPlayerList); 



var loadAlgorithm = function() {
	var i = 1;
	$.get("algorithm", function(responseJson) {
		var $ul = $("#algorithm");
		$ul.find("li").remove();
		if(isJsonEmpty(responseJson))
        {
			var $li = $("<li>").val("nullo").text("Nessun Algoritmo Presente").appendTo($ul);
            $li.addClass('list-group-item d-flex justify-content-between align-items-center match-item');
		}
		$.each(responseJson, function(index, algoresult) {
			console.log(algoresult.algorithm.algorithm);
			var $li = $("<li>").text(i + ". " + algoresult.algorithm.algorithm).appendTo($ul);
			i++;
			$li.addClass("list-group-item d-flex justify-content-between align-items-center match-item");
			var $div = $("<div>").text(algoresult.winrate + "%").appendTo($li);
		})
	})
}

$(document).on("click", "#buttonLoadAlgorithm", loadAlgorithm);


var loadStandardWords = function() {
	$.get("allStandardWords", function(responseJson) {
		var $dropdown = $("#parole");
		$.each(responseJson, function(index, string) {
			var $option = $("<option>").val(string).appendTo($dropdown);
			console.log($option.val());
		})
	})
}


var confermaMatch = function() {
	var param = {input : matchInputInModal, standardword: document.getElementById("inputText").value};
	$.post("setAdminMatch", $.param(param));
	setTimeout(() => {
      loadMatchList();
    }, 1000);
	$('#matchModal').modal('toggle');
	
}

function showConfirmationModalForMatch(input) {
	  matchInputInModal = input;
	  const correctAnswerElement = document.getElementById("inputMatch");
      correctAnswerElement.textContent ="Scegliere il match per l'input: " + matchInputInModal;
      $(document).on("click", "#modalMatchConfirm", confermaMatch);
      $('#matchModal').modal('show');
}

var confermaReport = function() {
	var param = {input : matchInputInModal, standardword: document.getElementById("inputText").value, idreport: idReport};
	$.post("setAdminMatchReport", $.param(param));
	setTimeout(() => {
      loadReportList();
    }, 1000);
	$('#matchModal').modal('toggle');
	
}

function showConfirmationModalForReport(input, id) {
	  matchInputInModal = input;
	  idReport = id;
	  const correctAnswerElement = document.getElementById("inputMatch");
      correctAnswerElement.textContent ="Scegliere il match per l'input: " + matchInputInModal;
      $(document).on("click", "#modalMatchConfirm", confermaReport);
      $('#matchModal').modal('show');
}
  
  
$(document).on("click", "#closeButton", function() {
	$('#matchModal').modal('toggle');
});


var trainAlgos = function() {
    $.post("trainAlgos");
    $("#trainMessage").text("Algoritmi allenati!");
    setTimeout(() => {
      $("#trainMessage").text("");
    }, 5000);
    
}

$(document).on("click", "#trainAlgoBtn", trainAlgos); 


