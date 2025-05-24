export async function ListConsults() {
    try {
        const res = await fetch('http://localhost:8080/consults/list');
        if (!res.ok) {
            throw new Error('Erro ao buscar consultas');
        }
        const data = await res.json();
        console.log("Requisição das consultas", data);
        return data;
    } catch (err) {
        alert("Erro: " + err.message);
        return [];
    }
}