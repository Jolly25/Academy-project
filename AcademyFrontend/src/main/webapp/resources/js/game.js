let usedNumbers = [];
let countries;
let countryName;

function fetchData() {
    fetch('https://restcountries.com/v3.1/all')
        .then(response => response.json())
        .then(data => {
            countries = data;
            getFlag();
        });
}

function getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
}

function getFlag() {
    let randomNumber;
    do {
        randomNumber = getRandomInt(250);
    } while (usedNumbers.includes(randomNumber));

    usedNumbers.push(randomNumber);
    let flagURL = countries[randomNumber].flags.png;
    countryName = countries[randomNumber].name.common;
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
    getFlag();
});

fetchData();