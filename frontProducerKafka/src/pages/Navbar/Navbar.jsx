import { NavLink } from "react-router-dom";
import "./Navbar.css"; // Importa el CSS específico para Navbar

function Navbar() {
    return (
    <nav className="navbar">
        <div className="nav-container">
        <NavLink to="/" className="nav-link">Inicio</NavLink>
        <NavLink to="/doctor" className="nav-link">Doctores</NavLink>
        <NavLink to="/visualizacion" className="nav-link">Visualizacion</NavLink>
        </div>
    </nav>
    );
}

export default Navbar;