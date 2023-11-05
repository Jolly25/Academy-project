let usedNumbers = [];
let countries;
let countryName;
let array;
let score = 0;

let partita;
function getPartita() {
	let partitaStringa = document.currentScript.getAttribute("param1");
	partita = JSON.parse(partitaStringa);
	let arrayNotRandom = partita.countriesToGuess.slice();
	array = arrayNotRandom.sort((a, b) => 0.5 - Math.random());
}

function sendPartitaFinita() {
	partita.score = score;
	let partitaFinita = JSON.stringify(partita);
	document.getElementById("partitaFinitaInput").value = partitaFinita;
	document.getElementById("partitaFinitaForm").submit();
}

getPartita();


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
   	let x = 0;
   	for(let j = 0; j < array.length; j++){
		 for(let i = 0; i < countries.length;  i++) {
			if(x != 1) {
				if(countries[i].name.common === array[j]) {
					flagURL = countries[i].flags.png;
					countryName = countries[i].name.common;
					array.splice(j, 1);
					x = 1;
				}
			}
			else {
				break;
			}
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

document.getElementById('confirmButton').addEventListener('click', function() {
    let userInput = document.getElementById('userInput').value;
    
    
    if (userInput.toLowerCase() === countryName.toLowerCase()) {
		score++;
        alert('Risposta corretta! Si tratta di ' + countryName);
    } else {
        alert('Sbagliato :( la risposta corretta era ' + countryName);
    }

	if(array.length > 0) getFlag();
	else sendPartitaFinita();
});

fetchData();