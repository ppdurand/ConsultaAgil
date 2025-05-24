import { useEffect, useState } from "react";
import { Button, Card, DatePicker, Form, Input, Select } from "antd";
import { ListPacient } from "../../Requests/ListPacient.jsx";

export function CreateConsult() {
    const [options, setOptions] = useState([]);

    async function handleSaveConsult(values) {
        const payload = {
            ...values,
            date: values.date.format("YYYY-MM-DDTHH:mm:ss"), // ⬅️ formato ISO LocalDateTime
        };
        console.log("Payload", payload);
        try {
            const res = await fetch('http://localhost:8080/consults/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(payload),
            });

            if (!res.ok) {
                const error = await res.json()
                throw new Error(error.message || 'Erro ao fazer cadastro');
            }

            const data = await res.json()
            console.log(data);
            alert('Consulta criada com sucesso!')

        } catch (err) {
            alert(err.message)
        }
    }

    useEffect(() => {
        async function fetchPacients() {
            const allPacients = await ListPacient(); // Agora está certo!
            const formattedOptions = allPacients.map((pacient) => ({
                value: pacient.id,
                label: pacient.nome,
            }));
            setOptions(formattedOptions);
        }

        fetchPacients();
    }, [])
    return (
        <div className='register-container'>
            <Card className='register-card'>
                <h1 className='register-title'>Marcar Consulta</h1>
                <Form onFinish={handleSaveConsult} layout='vertical'>
                    <Form.Item
                        label="Nome do paciente"
                        name="patientId"
                        rules={[{ required: true, message: 'Informe o nome do paciente' }]}
                    >
                        <Select options={options} placeholder="Nome do paciente" />
                    </Form.Item>
                    <Form.Item
                        label="Médico"
                        name="doctor"
                        rules={[{ required: true, message: 'Doutor(a)' }]}
                    >
                        <Input placeholder="Nome do médico" />
                    </Form.Item>
                    <Form.Item
                        label="Data da consulta"
                        name="date"
                        rules={[{ required: true, message: 'Por favor selecione a data!' }]}
                    >
                        <DatePicker
                            showTime
                            format="DD/MM/YYYY HH:mm"
                            placeholder="Data e hora da consulta"
                        />
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" block htmlType="submit">Registrar consulta</Button>
                    </Form.Item>
                </Form>
            </Card>
        </div>
    );
}
