const ReservationAPI = {
    seePatients: async () => {
        const response = await fetch("patient/list");
        return await response.json();
    },
    seeDevices: async () => {
        const response = await fetch("device/list");
        return await response.json();
    }
}

async function getPatients() {
    const patients = await ReservationAPI.seePatients();
    const patientSelect = document.getElementById("Patients");
    patientSelect.innerHTML = patients.map(patient =>
        `<option value="${patient.id}">${patient.fname} ${patient.sname}</option>`
    ).join("");
}

async function getDevices() {
    const devices = await ReservationAPI.seeDevices();
    const deviceSelect = document.getElementById("Devices");
    deviceSelect.innerHTML = devices.map(device =>
        `<option value="${device.id}">${device.type} in room ${device.room}</option>`
    ).join("");
}

getPatients().then(() => console.log("Patients loaded"));
getDevices().then(() => console.log("Devices loaded"));

document.getElementById("reservationForm").addEventListener("submit", async e => {
    e.preventDefault();
    const form = new FormData(e.target);

    const payload = {
        patientId: form.get("Patients"),    // ✅ gibt die gewählte ID zurück, passt zu ReservationRequest
        deviceId: form.get("Devices"),      // ✅ gleich
        date: form.get("reservationDate"),
        bodyregion: form.get("Bodyregion"),
        comments: form.get("Comments")
    }

    try {
        const response = await fetch("reservation/add", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(payload)
        });
        if (response.ok) {
            alert("Reservation added successfully!");
            window.location.href = "index.html";
        } else {
            alert("Failed to add reservation.");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("An error occurred while adding the reservation.");
    }
});