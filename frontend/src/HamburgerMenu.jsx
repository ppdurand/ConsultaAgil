import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./HamburgerMenu.css";

export function HamburgerMenu() {
  const [open, setOpen] = useState(false);

  return (
    <div className="hamburger-menu-container">
      <button
        className="hamburger-btn"
        onClick={() => setOpen((prev) => !prev)}
        aria-label="Abrir menu"
      >
        <span className="hamburger-icon">☰</span>
      </button>
      {open && (
        <nav className="hamburger-nav">
          <ul>
            <li><Link to="/patients" onClick={() => setOpen(false)}>Pacientes</Link></li>
            <li><Link to="/patient/new" onClick={() => setOpen(false)}>Novo Paciente</Link></li>
            <li><Link to="/consults" onClick={() => setOpen(false)}>Consultas</Link></li>
            <li><Link to="/consult/new" onClick={() => setOpen(false)}>Nova Consulta</Link></li>
            <li><Link to="/doctor/new" onClick={() => setOpen(false)}>Novo médico</Link></li>
            <li><Link to="/calendar" onClick={() => setOpen(false)}>Calendário</Link></li>
          </ul>
        </nav>
      )}
    </div>
  );
}
