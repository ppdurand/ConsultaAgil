// src/components/Doctor/CreateDoctor.jsx
import { useEffect, useState } from "react";
import { Button, Card, Form, Input, Select } from "antd";
import { CreateDoctorRequest } from "../../Requests/CreateDoctorRequest.js"; 

export function CreateDoctor() {
    const especialidadeOptions = ListEspecialidades()


    async function handleSaveDoctor(values) {
        const payload = {
            name: values.name,
            especialidadeMedica: values.especialidadeMedica,
        };
        console.log("Payload do médico", payload);

        try {
            const data = await CreateDoctorRequest(payload);
            console.log(data);
            alert('Médico cadastrado com sucesso!');

        } catch (err) {
            alert(err.message);
        }
    }

    return (
        <div className='register-container'>
            <Card className='register-card'>
                <h1 className='register-title'>Cadastrar Médico</h1>
                <Form onFinish={handleSaveDoctor} layout='vertical'>
                    <Form.Item
                        label="Nome do Médico"
                        name="name"
                        rules={[{ required: true, message: 'Informe o nome do médico!' }]}
                    >
                        <Input placeholder="Nome completo do médico" />
                    </Form.Item>

                    <Form.Item
                        label="Especialidade"
                        name="especialidadeMedica"
                        rules={[{ required: true, message: 'Selecione a especialidade!' }]}
                    >
                        <Select
                            options={especialidadeOptions}
                            placeholder="Selecione a especialidade"
                        />
                    </Form.Item>

                    <Form.Item>
                        <Button type="primary" block htmlType="submit">
                            Cadastrar Médico
                        </Button>
                    </Form.Item>
                </Form>
            </Card>
        </div>
    );
}

function ListEspecialidades() {
    const especialidades = [
        "CARDIOLOGIA",
        "DERMATOLOGIA",
        "PEDIATRIA",
        "CLINICA_GERAL",
        "GINECOLOGIA_OBSTETRICIA",
        "ORTOPEDIA",
        "OFTALMOLOGIA",
        "GASTROENTEROLOGIA",
        "ENDOCRINOLOGIA",
        "PSIQUIATRIA",
        "NEUROLOGIA",
        "OTORRINOLARINGOLOGIA",
        "UROLOGIA",
        "ANESTESIOLOGIA",
        "ONCOLOGIA"
    ];

    return especialidades.map(esp => ({
        value: esp,
        label: esp.replace(/_/g, ' ')
                                
    }));
}