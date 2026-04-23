
let payload = null;
const status=document.getElementById("statusBox");
function calculatePruefziffer(ssn) {
    const weights = [3, 7, 9, 5, 8, 4, 2, 1, 6];
    let sum = 0;

    let index = 0;

    for (let i = 0; i < 10; i++) {
        if (i === 3) continue;
        sum += (ssn.charAt(i) - '0') * weights[index];
        index++;
    }

    return sum % 11 === ssn.charAt(3) - '0';
}

    document.getElementById("form").addEventListener("submit",async(e)=> {
        e.preventDefault();
        const form = new FormData(e.target);
        const fName = form.get("fName");
        const sName = form.get("sName");
        const birthDate = form.get("birth");
        const gender = form.get("gender");
        const ssn = form.get("ssn");

        payload = {
            fName: fName,
            sName: sName,
            birthDate: birthDate,
            gender: gender,
            ssn: ssn
        }
        let checkSsn = ssn.toString();
        let pruefziffer = calculatePruefziffer(checkSsn);
        const birth= new Date(birthDate);
        if (fName.length === 0) {
            status.innerHTML = '<div class="bg-danger text-center">Please write a first Name!</div>'
            return;
        }
        if (sName.length === 0) {
            status.innerHTML = '<div class="bg-danger text-center">Please write a surname! </div>'
            return;
        }
        if (isNaN(birth.getTime())) {
            status.innerHTML = '<div class="bg-danger text-center"> This Time does not exist!</div>'
            return;
        } else if (birth > new Date()) {
            status.innerHTML = '<div class="bg-danger text-center"> This Time is in the future!</div>'
            return;
        }
        if (!(gender==="male" || gender==="female" || gender==="other")) {
            status.innerHTML = '<div class="bg-danger text-center"> Please put in a valid gender!</div>'
            return;
        }
        console.log("SSN:", ssn, "Länge:", ssn.length, "Prüfziffer berechnet:", pruefziffer, "SSN[3]:", parseInt(checkSsn[3]));
        if (ssn.length !== 10 || !calculatePruefziffer(ssn)) {
            status.innerHTML = '<div class="bg-danger text-center"> Please put in a valid ssn!</div>'
            return;
        }
        console.log("sending....");
        try {
            const response = await fetch("patient/add", {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(payload)
            });
            if (!response.ok) {
                status.innerHTML = '<div class="bg-danger text-center"> Something went wrong!</div>'
                return;
            }
        }catch(err){
            status.innerHTML = '<div class="bg-danger text-center"> Something went wrong!</div>'
            return;
        }
        status.innerHTML= '<div class="bg-success text-center"> Patient added successfully!</div>'
    });



