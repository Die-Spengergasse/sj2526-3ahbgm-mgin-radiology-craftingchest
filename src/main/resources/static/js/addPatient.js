
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
            if(!gender.includes("M")||!gender.includes("W")||!gender.includes("D"))
            const reponse= await fetch("patient/add",{
                method:"POST",
                headers:{"Content-Type":"application/json"},
                body:JSON.stringify(payload)
            });

    });


}