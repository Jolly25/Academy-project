let usedNumbers = [];
let countries;
let array = new Array;
let score = 0;
let countryName;

let flag = document.currentScript.getAttribute("param1");
let match = document.currentScript.getAttribute("param2");


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
		if(countries[i].name.common === flag) {
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


fetchData();


