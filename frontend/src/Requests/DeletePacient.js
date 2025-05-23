export function DeletePacient(id) {
    return fetch(`http://localhost:8080/patient/delete/${id}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then((res) => {
            if (!res.ok) {
                throw new Error('Erro ao excluir paciente');
            }
            return res.json();
        })
        .catch((err) => {
            alert("Erro aaa: " + err.message);
        });
}