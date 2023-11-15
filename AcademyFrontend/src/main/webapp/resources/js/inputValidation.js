document.getElementById("indovina_form").addEventListener("submit", 
	function(e) {
		if(window.timerAlive) {
			let input = document.getElementById("userInput").value;
			if(validateForm(input)) {
				e.preventDefault();
				document.getElementById("error").innerHTML = errorMsg;
			}
		}

	}
)

let errorMsg = "";
function validateForm(input) {
	if(input == "") {
		return false;
	}
	
	let regex = /^[a-zA-Z ']+$/;
	if (!regex.test(input)) {
   		errorMsg = "Non puoi inserire numeri o simboli speciali";
   		return true;
	}
	
}