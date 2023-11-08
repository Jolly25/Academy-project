let flag = document.currentScript.getAttribute("param1");
let previousMatch = document.currentScript.getAttribute("param2");
let previousInput = document.currentScript.getAttribute("param3");
let previousFlag = document.currentScript.getAttribute("param4");


window.addEventListener('load', function() {
	if(previousFlag != null || previousMatch != null || previousInput != null) {
	console.log("modale");
	console.log(previousMatch);
	console.log(previousFlag);
	  if (previousMatch.toLowerCase().trim() === previousFlag.toLowerCase().trim()) {
	    showCorrectModal(previousInput, previousMatch); // Visualizza la modale per la risposta corretta
	    incrementCounter();
	  } else {
	    showWrongModal(previousInput, previousMatch, previousFlag); // Visualizza la modale per la risposta errata
	  }
	  
	}
});

// Funzione per visualizzare la modale di risposta corretta
  function showCorrectModal(matchedWord, correctWord) {
    const correctModal = document.getElementById("correctModal");
    const correctAnswerElement = document.getElementById("matchedWord");
    correctAnswerElement.textContent ="Risposta corretta: " + matchedWord + " = " + correctWord;
    correctModal.style.display = "block";
    setTimeout(() => {
      correctModal.style.display = "none";
    }, 10000);
  }

  // Funzione per visualizzare la modale di risposta errata
  function showWrongModal(previousInput, previousMatch, previousFlag) {
    const wrongModal = document.getElementById("wrongModal");
    const correctAnswerElement = document.getElementById("correctAnswer");
    correctAnswerElement.textContent = "Hai inserito: " + previousInput + " = " + previousMatch + "\n Risposta corretta: " + previousFlag;
    wrongModal.style.display = "block";
    setTimeout(() => {
      wrongModal.style.display = "none";
    }, 10000);
  }