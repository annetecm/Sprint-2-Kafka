import Producer from "../../components/Producer";

function Doctor() {
    return (
        <Producer
            title="Sistema para doctores"
            description="Gestión de pacientes y citas. Todos los eventos se envían a Kafka y el consumer procesa las acciones."
            actions={[
                {
                    label: "Registrar paciente",
                    endpoint: "/producer/patient/register",
                    successMessage: "Registro de paciente",
                    fields: [
                        { name: "name", label: "Nombre"},
                        { name: "lastname", label: "Apellido"},
                        { name: "phone", label: "Teléfono" }
                    ]
                },
                {
                    label: "Actualizar paciente",
                    endpoint: "/producer/patient/update",
                    successMessage: "Actualizacion de paciente",
                    fields: [
                       { name: "name", label: "Nombre"},
                        { name: "lastname", label: "Apellido"},
                        { name: "phone", label: "Teléfono" }
                    ]
                },
                {
                    label: "Eliminar paciente",
                    endpoint: "/producer/patient/delete",
                    successMessage: "Eliminacion de paciente",
                    fields: [
                        { name: "name", label: "Nombre"},
                        { name: "lastname", label: "Apellido"},
                        { name: "phone", label: "Teléfono" }
                    ]
                },
                {
                    label: "Crear cita",
                    endpoint: "/producer/appointment/create",
                    successMessage: "Creacion de cita",
                    fields: [
                        { name: "name", label: "Nombre"},
                        { name: "lastname", label: "Apellido"},
                        { name: "motive", label: "Motivo" }
                    ]
                },
                {
                    label: "Cancelar cita",
                    endpoint: "/producer/appointment/cancel",
                    successMessage: "Cancelacion de cita",
                    fields: [
                        { name: "appointment_id", label: "ID de la cita"},
                        { name: "name", label: "Nombre del paciente"},
                        { name: "reason", label: "Razón de cancelación" }
                    ]
                },
                {
                    label: "Reprogramar cita",
                    endpoint: "/producer/appointment/reschedule",
                    successMessage: "Reprogramacion de cita",
                    fields: [
                        { name: "appointment_id", label: "ID de la cita" },
                        { name: "name", label: "Nombre del paciente"},
                        { name: "notes", label: "Notas", placeholder: "Ej: Motivo del cambio" }
                    ]
                }
            ]}
        />
    );
}

export default Doctor;