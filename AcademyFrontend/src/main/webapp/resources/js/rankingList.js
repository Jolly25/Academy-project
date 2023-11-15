window.addEventListener('load', function() {	
	loadRankingList();
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


var loadRankingList = function() {
	var i = 1;
	$.get("usersRanking", function(responseJson) {
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

$(document).on("click", "#buttonLoadRanking", loadRankingList);