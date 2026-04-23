import { NavLink } from "react-router-dom";
import "./Navbar.css"; 

function Navbar() {
    return (
    <nav className="navbar">
        <div className="nav-container">
        <NavLink to="/" className="nav-link">Inicio</NavLink>
        <NavLink to="/doctor" className="nav-link">Doctores</NavLink>
        <NavLink to="/visualization" className="nav-link">Visualización</NavLink>
        </div>
    </nav>
    );
}

export default Navbar;