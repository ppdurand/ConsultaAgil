import { Form, Select } from "antd";
import { ListPacient } from "../../Requests/ListPacient.jsx";

export function CreateConsult() {
    function patientOptions(){
        const allPacients = ListPacient()
        const options = allPacients.map((pacient) => ({
            value: pacient.id,
            label: pacient.nome,
        }));
        return options;
    }
    return(
        <div>
            <Form>
                <Form.Item
                    label="Paciente"
                    name="pacient"
                    rules={[{ required: true, message: 'Por favor insira o nome!' }]}
                >
                    <Select options={() => patientOptions()} />
                </Form.Item>

                <Form.Item>
                    <button type="submit">Criar Consulta</button>
                </Form.Item>
            </Form>
        </div>
    )
}