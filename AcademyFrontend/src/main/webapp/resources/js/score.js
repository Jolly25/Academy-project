let flag = document.getElementById("flag").innerHTML;
let previousMatch = document.getElementById("previousMatch").innerHTML;
let previousInput = document.getElementById("previousInput").innerHTML;
let previousFlag = document.getElementById("previousFlag").innerHTML;


window.addEventListener('load', function() {
	if(previousFlag != null || previousMatch != null || previousInput != null) {
		console.log(previousFlag);
		console.log(previousInput);
		console.log(previousMatch);

	if(previousInput === "") showWrongModal(previousInput, previousMatch, previousFlag);
	else {
		if (previousMatch.toLowerCase().trim() === previousFlag.toLowerCase().trim()) {
		    showCorrectModal(previousInput, previousMatch); // Visualizza la modale per la risposta corretta
		    incrementCounter();
	  	} else {
	    	showWrongModal(previousInput, previousMatch, previousFlag); // Visualizza la modale per la risposta errata
	  	}
	}
	sessionStorage.removeItem("firstLoad");
	  
	}
});


var reportMatch = function() {
	var param = {input: previousInput};
    $.post("addreport", $.param(param));
}

var $bc =$("#reportButton");
$bc.click(reportMatch);
var $bw = $("#reportBtn")
$bw.click(reportMatch);


// Funzione per visualizzare la modale di risposta corretta
  function showCorrectModal(matchedWord, correctWord) {
    const correctModal = document.getElementById("correctModal");
    const correctAnswerElement = document.getElementById("matchedWord");
    correctAnswerElement.textContent ="Risposta corretta: " + matchedWord + " = " + correctWord;
    correctModal.style.display = "block";
    setTimeout(() => {
      correctModal.style.display = "none";
    }, 5000);
  }

  // Funzione per visualizzare la modale di risposta errata
  function showWrongModal(previousInput, previousMatch, previousFlag) {
    const wrongModal = document.getElementById("wrongModal");
    const correctAnswerElement = document.getElementById("correctAnswer");
    if(previousInput === "") {
		correctAnswerElement.textContent = "Nessun inserimento";
		document.getElementById("reportBtn").setAttribute('style', 'display:none !important;');
	}
    else correctAnswerElement.textContent = "Hai inserito: " + previousInput + " = " + previousMatch + "\n Risposta corretta: " + previousFlag;
    wrongModal.style.display = "block";
    setTimeout(() => {
      wrongModal.style.display = "none";
    }, 5000);
  }