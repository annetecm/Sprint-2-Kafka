import Producer from "../../components/Producer";

function Visualization() {
    return (
        <Producer
            title="Sistema de visualización"
            description="Consulta de citas y estado de pacientes."
            actions={[
                {
                    label: "Consultar estado",
                    endpoint: "/producer/status/inquiry",
                    successMessage: "Consulta de estado",
                    fields: [
                        { name: "patient_id", label: "ID del paciente" },
                        { name: "name", label: "Nombre del paciente"},
                        { name: "status", label: "Estado" }
                    ]
                },
                {
                    label: "Ver historial medico",
                    endpoint: "/producer/status/history",
                    successMessage: "Consulta de historial medico",
                    fields: [
                        { name: "patient_id", label: "ID del paciente" },
                        { name: "name", label: "Nombre del paciente"},
                        { name: "disease", label: "Enfermedades"}
                    ]
                }
            ]}
        />
    );
}

export default Visualization;