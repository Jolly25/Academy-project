
  
  {
    let usedCountries = [];
    let countries;
    let countryName;

    // Array di paesi
    const countryNames = [
      "Israel", "Uruguay", "Peru", "Japan", "Chile", "Netherlands", "Slovakia", "Bosnia and Herzegovina",
      "Czechia", "Italy", "Luxembourg", "Serbia", "Ivory Coast", "Turkey", "Colombia", "Brazil", "India",
      "China", "Greece", "Canada", "South Korea", "Russia", "Iceland", "Germany", "Morocco", "Romania",
      "Belgium", "Albania", "Mexico", "Spain", "Sweden", "Australia", "United Kingdom", "Tunisia",
      "Denmark", "Saudi Arabia", "Jamaica", "France", "Croatia", "South Africa", "Switzerland",
      "United States", "North Macedonia", "New Zealand", "Austria", "Slovenia", "Nigeria", "Portugal",
      "Finland", "Poland", "Cameroon", "Algeria"
    ];

    function fetchData() {
      fetch('https://restcountries.com/v3.1/all')
        .then(response => response.json())
        .then(data => {
          countries = data;
          getCountry();
        });
    }

    function incrementCounter() {
      var counter = document.getElementById("counter");
      var currentValue = parseInt(counter.innerHTML);
      counter.innerHTML = currentValue + 1;
      score++;
    }

    function getCountry() {
      let countryIndex;
      do {
        countryIndex = Math.floor(Math.random() * countryNames.length);
      } while (usedCountries.includes(countryIndex));

      usedCountries.push(countryIndex);
      let country = countryNames[countryIndex];
      let flagURL = getFlagURL(country);
      countryName = country;
      displayFlag(flagURL, countryName);
    }

    function getFlagURL(countryName) {
      for (let i = 0; i < countries.length; i++) {
        if (countries[i].name.common.toLowerCase() === countryName.toLowerCase()) {
          return countries[i].flags.png;
        }
      }
      return '';
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
        showCorrectModal(); // Visualizza la modale per la risposta corretta
        incrementCounter();
      } else {
        showWrongModal(countryName); // Visualizza la modale per la risposta errata
      }
      getCountry();
    });

    fetchData();
  }



  // Funzione per visualizzare la modale di risposta corretta
  function showCorrectModal() {
    const correctModal = document.getElementById("correctModal");
    correctModal.style.display = "block";
    setTimeout(() => {
      correctModal.style.display = "none";
    }, 2000);
  }

  // Funzione per visualizzare la modale di risposta errata
  function showWrongModal(correctAnswer) {
    const wrongModal = document.getElementById("wrongModal");
    const correctAnswerElement = document.getElementById("correctAnswer");
    correctAnswerElement.textContent = correctAnswer;
    wrongModal.style.display = "block";
    setTimeout(() => {
      wrongModal.style.display = "none";
    }, 2000);
  }

   // Funzione per visualizzare la modale finale del risultato
  function showGameResultModal() {
  const gameResultModal = document.getElementById("gameResultModal");
  const gameResultMessage = document.getElementById("gameResultMessage");
  gameResultMessage.textContent = "Hai totalizzato: " + score + " bandiere indovinate";
  gameResultModal.style.display = "block";
  setTimeout(() => {
      correctModal.style.display = "none";
    }, 2000);
}

// Aggiungi un event listener per chiudere la modale quando si clicca sulla "X"
document.getElementById("closeGameResultModal").addEventListener("click", function() {
  closeGameResultModal();
});

// Funzione per chiudere la modale
function closeGameResultModal() {
  const gameResultModal = document.getElementById("gameResultModal");
  gameResultModal.style.display = "none";
}