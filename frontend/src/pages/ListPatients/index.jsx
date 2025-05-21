import { Table } from "antd";

export function ListPatients(){

    const patients = fetch('http://localhost:8080/patient/list')
        .then((res) => {
            if (!res.ok) {
                const error = res.json()
                throw new Error(error.message || 'Erro ao buscar pacientes');
            }
            return res.json()
        })
        .then((data) => {
            console.log(data);
            return data
        })
        .catch((err) => {
            alert(err.message, "complicado")
        })
    
    const columns = [{
        title: 'Nome',
        dataIndex: 'name',
        key: 'name',
    },
    {
        title: 'Telefone',
        dataIndex: 'telephone',
        key: 'telephone',
    },
    {
        title: 'Ações',
        key: 'action',
        render: (_, record) => (
            <span>
                <a>Editar</a>
                <a style={{ marginLeft: 16 }}>Excluir</a>
            </span>
        ),
    }]

    return (
        <div className="table-container">
            <Table dataSource={patients} columns={columns} />
        </div>
    )
}