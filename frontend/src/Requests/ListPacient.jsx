export function ListPacient(){
    return fetch('http://localhost:8080/patient/list')
            .then((res) => {
                if (!res.ok) {
                    throw new Error('Erro ao buscar pacientes');
                }
                return res.json();
            })
            .then((data) => {
                console.log(data);
                setPatients(data);
            })
            .catch((err) => {
                alert("Erro: " + err.message);
            });
}