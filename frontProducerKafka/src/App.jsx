import { BrowserRouter as Router, Navigate, Routes, Route } from "react-router-dom";
import Navbar from "./pages/Navbar/Navbar";
import Home from "./pages/mainpages/Home";
import Doctor from "./pages/mainpages/Doctor";
import Visualization from "./pages/mainpages/Visualization";
import Default from "./pages/mainpages/Default";
import "./App.css";


function App() {
  return (
    <Router>
      <div className="app-shell">
        <Navbar />
        <main className="content">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/doctor" element={<Doctor />} />
            <Route path="/visualizacion" element={<Visualization />} />
            <Route path="/clientes" element={<Navigate to="/doctor" replace />} />
            <Route path="/menus" element={<Navigate to="/visualizacion" replace />} />
            <Route path="*" element={<Default />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;