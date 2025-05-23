import { useEffect, useState } from "react";
import { Table } from "antd";
import { DeletePacient } from "../../Requests/DeletePacient";

export function ListPatients() {
    const [patients, setPatients] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/patient/list')
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
    }, []);

    function handleDelete(id){
        console.log(id)
        DeletePacient(id)
    }

    const columns = [
        {
            title: 'Nome',
            dataIndex: 'nome',
            key: 'nome',
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
                    <a  onClick={() => handleDelete(record.id)}style={{ marginLeft: 16 }}>Excluir</a>
                </span>
            ),
        }
    ];

    return (
        <div className="table-container">
            <Table dataSource={patients} columns={columns} rowKey="id" />
        </div>
    );
}
