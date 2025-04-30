async function getotp() {
	
		const email = document.getElementById("email").value;

		console.log("geting data");
		let response= await fetch('/verification', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({ email: email })
		});
		
		if(response.status === 200) {
			alert("OTP sent to your email");
			let otpuser= prompt("Enter OTP");
			response.json().then(data => {
				if(data["otpString"]==otpuser){
					alert("OTP verified");
					let f=document.getElementById("container");
					let f1=document.getElementById("otp-container");
					f1.style.display="none";
					f.style.display="block";
		            document.getElementById("email1").value = email;
				}
				else{
					alert("Invalid OTP");
					}
						 
						});
			}
		
			}
	console.log("getting otp");

