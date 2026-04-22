
let payload = null;
const status=document.getElementById("statusBox");
async function addPatient(){

    document.getElementById("form").addEventListener("submit",async(e)=>{
        e.preventDefault();
        const form = new FormData(e.target);
        const fName=form.get("fName");
        const sName=form.get("sName");
        const birthDate=form.get("birth");
        const gender=form.get("gender");
        const ssn=form.get("ssn");

        payload={
            fName: fName,
            sName: sName,
            birthDate: birthDate,
            gender: gender,
            ssn: ssn
        }
            let checkSsn= ssn.toString();
            let pruefziffer= (parseInt(checkSsn.charAt(0))*2+parseInt(checkSsn.charAt(1))*3+parseInt(checkSsn.charAt(2))*4+parseInt(checkSsn.charAt(3))*5+parseInt(checkSsn.charAt(4))*6+parseInt(checkSsn.charAt(5))*7+parseInt(checkSsn.charAt(6))*8+parseInt(checkSsn.charAt(7))*9+parseInt(checkSsn.charAt(8))*10)%11;
            if(fName.length===0){
                status.innerHTML = '<div class="bg-danger text-center">Please write a first Name!</div>'

            }
            if(sName.length===0){
                status.innerHTML='<div class="bg-danger text-center">Please write a surname! </div>'
            }
            if(!isNaN(birthDate.getTime())){
                status.innerHTML='<div class="bg-danger text-center"> This Time does not exist!</div>'
            }
            else if(birthDate>Date.now()){
                status.innerHTML='<div class="bg-danger text-center"> This Time is in the future!</div>'
            }
            if(!gender.includes("M")||!gender.includes("F")||!gender.includes("D") || !gender.includes("m") || !gender.includes("f") || !gender.includes("d")){
                status.innerHTML='<div class="bg-danger text-center"> Please put in a valid gender!</div>'
            }
            if(ssn.length!==10||!isNaN(ssn)|| parseInt(checkSsn.charAt(4))!==pruefziffer){
                status.innerHTML='<div class="bg-danger text-center"> Please put in a valid ssn!</div>'
            }

                const reponse= await fetch("patient/add",{
                method:"POST",
                headers:{"Content-Type":"application/json"},
                body:JSON.stringify(payload)
                });

    });


}