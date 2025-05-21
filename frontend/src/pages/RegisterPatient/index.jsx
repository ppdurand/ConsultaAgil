import React from 'react';
import { Button, Card, Form, Input } from 'antd';

import './style.css';

export function RegisterPatient() {
    async function savePatient(values) {
        try{
            const res = await fetch('http://localhost:8080/patient/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(values),
            });

            if (!res.ok) {
                const error = await res.json()
                throw new Error(error.message || 'Erro ao fazer cadastro');
            }

            const data = await res.json()
            console.log(data);
            alert('Conta criada com sucesso!')

        } catch (err) {
            alert(err.message)
        }
    }

    return (
        <div className='register-container'>
            <Card className='register-card'>
                <h1 className='register-title'>Adicionar Paciente</h1>
                <Form onFinish={savePatient} layout='vertical'>
                    <Form.Item
                        label="Nome do paciente"
                        name="name"
                        rules={[{ required: true, message: 'Informe o nome do paciente' }]}
                    >
                        <Input placeholder="Nome do paciente" />
                    </Form.Item>
                    <Form.Item
                        label="Telefone"
                        name="telephone"
                        rules={[{ required: true, message: 'Número do paciente' }]}
                    >
                        <Input placeholder="Número do pacient" />
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" block htmlType="submit">Registrar</Button>
                    </Form.Item>
                </Form>
            </Card>
        </div>
    );
}