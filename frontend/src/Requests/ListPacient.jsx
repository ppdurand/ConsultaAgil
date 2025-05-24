import { useEffect, useState } from "react";

export async function ListPacient(){
    try {
        const res = await fetch('http://localhost:8080/patient/list');
        if (!res.ok) {
            throw new Error('Erro ao buscar pacientes');
        }
        const data = await res.json();
        console.log("Requisição", data);
        return data;
    } catch (err) {
        alert("Erro: " + err.message);
        return [];
    }
    return patients
}