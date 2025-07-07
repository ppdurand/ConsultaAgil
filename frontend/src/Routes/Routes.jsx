import React from "react";
import { Routes, Route } from "react-router-dom";
import { RegisterPatient } from "../pages/RegisterPatient";
import { CreateConsult } from "../pages/CreateConsult";
import { ListPatients } from "../pages/ListPatients";
import { ListConsult } from "../ListConsult";
import { CalendarView } from "../pages/Calendar";
import { CreateDoctor } from "../pages/CreateDoctor";

export function AppRoutes() {
    return (
        <Routes>
            <Route path="/patients" element={<ListPatients/>}></Route>
            <Route path="/patient/new" element={<RegisterPatient/>}></Route>
            <Route path="/consults" element={<ListConsult/>}></Route>
            <Route path="/consult/new" element={<CreateConsult/>}></Route>
            <Route path="/calendar" element={<CalendarView/>}></Route>
            <Route path="/doctor/new" element={<CreateDoctor/>}></Route>
        </Routes>
    )
}