// src/components/Consult/CreateConsult.jsx
import { useEffect, useState } from "react";
import { Button, Card, DatePicker, Form, Select } from "antd";
import { ListPacient } from "../../Requests/ListPacient.jsx";
import { ListDoctors } from "../../Requests/ListDoctors.jsx";

export function CreateConsult() {
    const [patientOptions, setPatientOptions] = useState([]);
    const [doctorOptions, setDoctorOptions] = useState([]);

    async function handleSaveConsult(values) {
        const payload = {
            patientId: values.patientId,
            doctorId: values.doctorId,
            date: values.date.format("YYYY-MM-DDTHH:mm:ss"),
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
                const error = await res.json();
                throw new Error(error.message || 'Erro ao fazer cadastro da consulta.');
            }

            const data = await res.json();
            console.log(data);
            alert('Consulta criada com sucesso!');

        } catch (err) {
            alert(err.message);
        }
    }

    useEffect(() => {
        async function fetchPatients() {
            try {
                const allPatients = await ListPacient();
                const formattedOptions = allPatients.map((patient) => ({
                    label: patient.id,
                    value: patient.name,
                }));
                setPatientOptions(formattedOptions);
            } catch (error) {
                console.error("Erro ao carregar pacientes:", error);
                alert("Não foi possível carregar a lista de pacientes.");
            }
        }

        async function fetchDoctors() {
            try {
                const allDoctors = await ListDoctors();
                const formattedOptions = allDoctors.map((doctor) => ({
                    value: doctor.id,
                    label: `${doctor.name} (${doctor.especialidadeMedica.replace(/_/g, ' ')})`,
                }));
                setDoctorOptions(formattedOptions);
            } catch (error) {
                console.error("Erro ao carregar médicos:", error);
                alert("Não foi possível carregar a lista de médicos.");
            }
        }

        fetchPatients();
        fetchDoctors();
    }, []);

    return (
        <div className='register-container'>
            <Card className='register-card'>
                <h1 className='register-title'>Marcar Consulta</h1>
                <Form onFinish={handleSaveConsult} layout='vertical'>
                    <Form.Item
                        label="Paciente"
                        name="patientId"
                        rules={[{ required: true, message: 'Selecione o paciente!' }]}
                    >
                        <Select options={patientOptions} placeholder="Selecione o paciente" />
                    </Form.Item>

                    <Form.Item
                        label="Médico"
                        name="doctorId"
                        rules={[{ required: true, message: 'Selecione o médico!' }]}
                    >
                        <Select options={doctorOptions} placeholder="Selecione o médico" />
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