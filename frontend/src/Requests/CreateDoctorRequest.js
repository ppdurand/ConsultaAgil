// src/Requests/CreateDoctorRequest.jsx
export async function CreateDoctorRequest(doctorData) {
    try {
        const res = await fetch('http://localhost:8080/doctors', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(doctorData),
        });

        if (!res.ok) {
            const error = await res.json();
            throw new Error(error.message || 'Erro ao cadastrar o médico.');
        }

        return await res.json();
    } catch (err) {
        console.error("Erro na requisição de criação de médico:", err);
        throw err;
    }
}