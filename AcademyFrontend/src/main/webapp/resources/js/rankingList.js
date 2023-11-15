window.addEventListener('load', function() {
	loadMatchList();
	loadReportList();
	loadRanking();
	loadPlayerList();
	loadAlgorithm();
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