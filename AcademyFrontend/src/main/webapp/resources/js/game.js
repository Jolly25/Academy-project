  var width = 300,
    height = 300,
    timePassed = 0,
    timeLimit = 15  ;

  var fields = [{
    value: timeLimit,
    size: timeLimit,
    update: function() {
      return timePassed = timePassed + 1;
    }
  }];

  var nilArc = d3.arc()
    .innerRadius(width / 3 - 133)
    .outerRadius(width / 3 - 133)
    .startAngle(0)
    .endAngle(2 * Math.PI);

  var arc = d3.arc()
    .innerRadius(width / 3 - 55)
    .outerRadius(width / 3 - 25)
    .startAngle(0)
    .endAngle(function(d) {
      return ((d.value / d.size) * 2 * Math.PI);
    });

  var svg = d3.select(".container").append("svg")
    .attr("width", width)
    .attr("height", height);

  var field = svg.selectAll(".field")
    .data(fields)
    .enter().append("g")
    .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")")
    .attr("class", "field");

  var back = field.append("path")
    .attr("class", "path path--background")
    .attr("d", arc);

  var path = field.append("path")
    .attr("class", "path path--foreground");

  var label = field.append("text")
    .attr("class", "label")
    .attr("dy", ".35em");

  (function update() {
    field.each(function(d) {
      d.previous = d.value;
      d.value = d.update(timePassed);
    });

    path
      .transition()
      .duration(500)
      .attrTween("d", arcTween);

    if (timeLimit - timePassed <= 10) {
      pulseText();
    } else {
      label.text(function(d) {
        return d.size - d.value;
      });
    }

    if (timePassed <= timeLimit) {
      setTimeout(update, 1000 - (timePassed % 1000));
    } else {
      destroyTimer();
    }
  })();

  function pulseText() {
    back.classed("pulse", true);
    label.classed("pulse", true);

    if (timeLimit - timePassed >= 0) {
      label
        .style("font-size", "45px")
        .attr("transform", "translate(0, 4)")
        .text(function(d) {
          return d.size - d.value;
        });
    }

    label
      .transition()
      .duration(900)
      .style("font-size", "45px")
      .attr("transform", "translate(0, -10)");
  }

  function showConfirmationModal() {
	  const restartModal = document.getElementById('restartModal');
	  restartModal.style.display = 'block';
  }
  
  //conferma restart della pagina
	document.getElementById("confirmRestart").addEventListener("click", function() {
	  sessionStorage.removeItem("firstLoad");
	  document.getElementById("restart_form").submit();
	  restartModal.style.display = 'none';
	});
	
	  //annulla il restart della pagina
	document.getElementById("cancelRestart").addEventListener("click", function() {
	  restartModal.style.display = 'none';
	});



  // Aggiungi un event listener per gestire l'invio del modulo
  document.getElementById("userInput").addEventListener("keydown", function(event) {
    if (event.key === "Enter") {
      // Verifica se il tasto premuto Ã¨ "Invio"
      event.preventDefault(); // Impedisce l'invio del modulo predefinito
      document.getElementById("indovina").click(); // Simula il clic sul tasto "Indovina!"
    }
  });

var timerAlive = true;
  function destroyTimer() {

    label.transition()
      .duration(700)
      .style("opacity", "0")
      .style("font-size", "5")
      .attr("transform", "translate(0," + -40 + ")")
      .on("end", function() {
        field.selectAll("text").remove()
      });

    path.transition()
      .duration(700)
      .attr("d", nilArc);

    back.transition()
      .duration(700)
      .attr("d", nilArc)
      .on("end", function() {
        field.selectAll("path").remove()
      });
      
      timerAlive = false;
      document.getElementById("indovina").click();

  }

  function arcTween(b) {
    var i = d3.interpolateObject({ value: b.previous }, b);
    return function(t) {
      return arc(i(t));
    };
  }

let usedNumbers = [];
let countries;
let array = new Array;
let score = 0;
let countryName;

let flag = document.getElementById("flag").innerHTML;
let cca2 = document.getElementById("cca2").innerHTML;
let previousMatch = document.getElementById("previousMatch").innerHTML;
let previousInput = document.getElementById("previousInput").innerHTML;
let previousFlag = document.getElementById("previousFlag").innerHTML;


function fetchData() {
    fetch('https://restcountries.com/v3.1/all')
        .then(response => response.json())
        .then(data => {
            countries = data;
			getFlag();
        });
}

function getFlag() {
	let flagURL;
	
	for(let i = 0; i < countries.length;  i++) {
		if(countries[i].cca2 === cca2) {
			flagURL = countries[i].flags.png;
			countryName = countries[i].name.common;
		}
	}
	
    displayFlag(flagURL, countryName);
}

function displayFlag(flagURL, countryName) {
    let flagElement = document.getElementById('flagImage');
    let userInput = document.getElementById('userInput');
    userInput.value = ''; // Clear the input field
    flagElement.src = flagURL;
}


window.addEventListener('load', function() {
	if(sessionStorage.getItem("firstLoad") === null) {
		sessionStorage.setItem("firstLoad", true);
	}
	else {
		if(previousFlag != null || previousMatch != null || previousInput != null) {
			if(previousInput == "") showWrongModal(previousInput, previousMatch, previousFlag);
			else {
				if (previousMatch.toLowerCase().trim() === previousFlag.toLowerCase().trim()) {
				    showCorrectModal(previousInput, previousMatch); // Visualizza la modale per la risposta corretta
				    incrementCounter();
			  	} else {
			    	showWrongModal(previousInput, previousMatch, previousFlag); // Visualizza la modale per la risposta errata
			  	}
			}
		}
	}

});

fetchData();

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
		correctAnswerElement.textContent = "Nessun inserimento, la risposta corretta era: " + previousFlag;
		document.getElementById("reportBtn").setAttribute('style', 'display:none !important;');
	}
    else correctAnswerElement.textContent = "Hai inserito: " + previousInput + " = " + previousMatch + "\n Risposta corretta: " + previousFlag;
    wrongModal.style.display = "block";
    setTimeout(() => {
      wrongModal.style.display = "none";
    }, 5000);
  }



