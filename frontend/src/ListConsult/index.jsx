import { useEffect, useState } from "react";
import { ListConsults } from "../Requests/ListConsults.jsx";
import { List, Table } from "antd";
import { DeleteConsult } from "../Requests/DeleteConsult.jsx";

export function ListConsult() {
    const [consults, setConsults] = useState([]);
    useEffect(() => {
        async function fetchData() {
            const consultsfetch = await ListConsults();  // aguarda o resultado
            setConsults(consultsfetch);
        }
        fetchData();
    }, []);
    console.log("Consultas", consults)
    const columns = [
        {
            title: 'Nome do paciente',
            dataIndex: 'patient',
            key: 'patient',
            render: (_, record) => <span>{record.patient.nome}</span>,
        },
        {
            title: 'Data da consulta',
            dataIndex: 'data',
            key: 'data',
            format: 'DD/MM/YYYY',
        },
        {
            title: 'Ações',
            key: 'action',
            render: (_, record) => (
                <span>
                    <a>Editar</a>
                    <a onClick={() => DeleteConsult(record.id)} style={{ marginLeft: 16 }}>Excluir</a>
                </span>
            ),
        }
    ];

    return (
        <div className="table-container">
            <Table dataSource={consults} columns={columns} />
        </div>
    );
}