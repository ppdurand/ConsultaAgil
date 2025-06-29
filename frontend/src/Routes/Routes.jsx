import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { ListPacient } from "../Requests/ListPacient";
import { RegisterPatient } from "../pages/RegisterPatient";
import { CreateConsult } from "../pages/CreateConsult";

export function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/patients" element={<ListPacient/>}></Route>
                <Route path="/patient/new" element={<RegisterPatient/>}></Route>
                <Route path="/consults" element={<ListPacient/>}></Route>
                <Route path="/consult/new" element={<CreateConsult/>}></Route>
            </Routes>
        </BrowserRouter>
    )
}