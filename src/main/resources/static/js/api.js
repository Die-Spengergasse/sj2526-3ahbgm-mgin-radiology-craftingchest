const PatientAPI={
    getALL:async()=>{
        const response=await fetch("patient/list");
        const data= await response.json();
    },
    add:async(patient)=>{

        const reponse= await fetch("patient/add",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(patient)
        });
    }

}
const ReservationAPI={
    add:async(reservation)=>{
        const response=await fetch("reservation/add",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(reservation)
        });

    }
}
const DeviceAPI={
    add:async(device)=>{
        const res=await fetch("device/add",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(device)
        });
    },
    seeReservations:async(device)=>{
        const response=await fetch("device/reservations/"+device.id);
        const data= await response.json();
        return data;
    }
}

