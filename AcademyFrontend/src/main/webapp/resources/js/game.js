let usedNumbers = [];
let countries;
let countryName;

let str1 = document.getElementById("array").innerHTML;
let str2 = str1.substring(1, str1.length-1);
let arrayNotRandom = str2.split(", ");
let array = arrayNotRandom.sort((a, b) => 0.5 - Math.random());


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
        alert('Risposta corretta! Si tratta di ' + countryName);
    } else {
        alert('Sbagliato :( la risposta corretta era ' + countryName);
    }

	if(array.length > 0) getFlag();
	else console.log("finito");
});

fetchData();