export function DeleteConsult(id){
    console.log(id)
    try{
        const res = fetch(`http://localhost:8080/consults/delete/${id}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
        });
        if (!res.ok) {
            throw new Error('Erro ao deletar consulta');
        }
        alert("Consulta deletada com sucesso")
    } catch (err) {
        alert("Erro: " + err.message);
    }
}