export async function ListDoctors() {
    try {
        const response = await fetch('http://localhost:8080/doctors');
        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.message || 'Erro ao buscar a lista de médicos.');
        }
        const data = await response.json();
        return data;
    } catch (error) {
        console.error("Erro ao listar médicos:", error);
        throw error;
    }
}