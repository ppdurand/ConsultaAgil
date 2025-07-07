import { Calendar, Badge } from "antd";
import { useState, useEffect } from "react";
import { ListConsults } from "../../Requests/ListConsults";
import dayjs from "dayjs";

export function CalendarView() {
    const [consults, setConsults] = useState([]);

    useEffect(() => {
        async function fetchData() {
            try {
                const consultsfetch = await ListConsults();
                setConsults(consultsfetch);
            } catch (error) {
                console.error("Erro ao buscar consultas:", error);
            }
        }
        fetchData();
    }, []);

    const dateCellRender = (value) => {
        const currentDate = value.format("YYYY-MM-DD");

        const consultsToday = consults.filter((consult) => {
            const consultDate = dayjs(consult.data).format("YYYY-MM-DD");
            return consultDate === currentDate;
        });

        return (
            <ul style={{ listStyle: "none", padding: 0, margin: 0 }}>
                {consultsToday.map((consult) => (
                    <li key={consult.id}>
                        <Badge
                            status="processing"
                            text={`${consult.patient.nome}`}
                        />
                    </li>
                ))}
            </ul>
        );
    };

    return (
        <Calendar dateCellRender={dateCellRender} />
    );
}
