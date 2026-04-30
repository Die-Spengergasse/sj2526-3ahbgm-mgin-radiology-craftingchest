const DeviceAPI= {

    seeReservations: async (device) => {
        const response = await fetch("device/reservations/" + device.id);
        const data= await response.json();
        return data;
    }
}

async function showReservations(deviceId){
    const modal = new bootstrap.Modal(document.getElementById("ReservationModal"));
    modal.show();
    const reservations = await DeviceAPI.seeReservations({id: deviceId});
    console.log(reservations);
    const reservationsBody = document.getElementById("ReservationsBody");
    reservationsBody.innerHTML= reservations.map(reservation =>`
    <tr>
    <td>${reservation.patient.fname} ${reservation.patient.sname}</td>
    <td>${reservation.date}</td>
    <td>${reservation.bodyregion}</td>
    <td>${reservation.comments}</td>
    </tr>`)
        .join(" ");

}

async function loadDevices(){
    const response = await fetch("device/list");
    const data = await response.json();
    const tbody = document.getElementById("Devicebody");
    tbody.innerHTML = data.map(device =>
        `<tr>
        <td>${device.type}</td>
        <td>${device.room}</td>
        <td>
            <button type="button" class="btn btn-primary" id="Modalbutton" onclick="showReservations(${device.id})">
                view Reservations
            </button>
        </td>
    </tr>`).join("");

}
loadDevices().then(r => console.log("Devices loaded"));