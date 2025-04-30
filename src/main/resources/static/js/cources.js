console.log("hello");

async function showCourses() {
    let url = "/user/";
    let d = document.getElementById("search");
    let d1 = d.value.trim();
    

    if (d1 !== "" && !isNaN(Number(d1))) {
        url = url + `getbyId/${d1}`;
    } else if (d1 !== "") {
        url = url + `getbyname/${d1}`;
    } else {
        url = url + "getallcourse";
    }

  

    let promise = await fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    });

    if (promise.status === 200) {
        let data = await promise.json();
      
        let container = document.getElementById("course");
        container.innerHTML = ""; // Clear old results

        for (let x of data) {
            // Course Card
            let card = document.createElement("div");
            card.style.background = "#f9f9f9";
            card.style.padding = "20px";
            card.style.marginBottom = "20px";
            card.style.borderRadius = "12px";
            card.style.boxShadow = "0 4px 6px rgba(0,0,0,0.05)";
            card.style.border = "1px solid #ddd";

            let h = document.createElement("h3");
            h.textContent = `${x["title"]} (ID: ${x["id"]})`;
            h.style.marginBottom = "10px";
            h.style.color = "#3b3b3b";

            let p = document.createElement("p");
            p.textContent = x["description"];
            p.style.marginBottom = "10px";
            p.style.color = "#666";

            let span = document.createElement("span");
            span.textContent = "₹" + x["price"];
            span.style.display = "block";
            span.style.fontWeight = "600";
            span.style.color = "#6c5ce7";
            span.style.marginBottom = "15px";

            let btn = document.createElement("button");
            btn.textContent = "Enroll in Course";
            btn.style.padding = "8px 16px";
            btn.style.border = "none";
            btn.style.borderRadius = "6px";
            btn.style.backgroundColor = "#6c5ce7";
            btn.style.color = "#fff";
            btn.style.cursor = "pointer";

            btn.onclick = async () => {
                await enrollInCourse(x["id"]);
            };

            card.appendChild(h);
            card.appendChild(p);
            card.appendChild(span);
            card.appendChild(btn);
            container.appendChild(card);
        }
    } else {
        console.error("Failed to fetch courses:", promise.status);
    }
}

async function enrollInCourse(courseId) {
    const response = await fetch(`/user/enroll/${courseId}`, {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    });

	let data= await response.text();
	    console.log(data);
    if (response.ok && response.data === "already enrolled") {
        alert(`Allready enrolled in course ID ${courseId}!`+ response.body);
    } else if (response.ok) {
        alert(`Successfully enrolled in course ID ${courseId}!` + response.body);
    }
	else {
		alert(`Failed to enroll in course ID ${courseId}.`+ response.body);
	}
}
