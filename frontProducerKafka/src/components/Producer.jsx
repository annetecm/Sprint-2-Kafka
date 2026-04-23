import { useState } from "react";

const API_BASE_URL = "http://localhost:8000";

export default function Producer({ title, description, actions, placeholder }) {
    const [formData, setFormData] = useState({});
    const [status, setStatus] = useState("");
    const [loadingAction, setLoadingAction] = useState("");

    const handleFieldChange = (actionLabel, fieldName, value) => {
        setFormData(prev => ({
            ...prev,
            [actionLabel]: {
                ...(prev[actionLabel] || {}),
                [fieldName]: value
            }
        }));
    };

    const sendMessage = async (action) => {
        const actionData = formData[action.label] || {};
        
        
        const payload = action.fields
            ? action.fields.map(f => actionData[f.name] || "").join(" | ")
            : "";

        if (!payload.trim()) {
            setStatus("Completa todos los campos antes de enviar.");
            return;
        }

        setLoadingAction(action.label);
        setStatus(`Enviando ${action.label.toLowerCase()}...`);

        try {
            const res = await fetch(`${API_BASE_URL}${action.endpoint}`, {
                method: "POST",
                headers: {
                    "Content-Type": "text/plain;charset=UTF-8"
                },
                body: payload
            });

            if (!res.ok) {
                throw new Error(`Error ${res.status}`);
            }

            setStatus(`${action.successMessage} enviado al backend.`);
            setFormData(prev => ({
                ...prev,
                [action.label]: {}
            }));
        } catch (error) {
            setStatus(`No se pudo enviar el mensaje: ${error.message}`);
        } finally {
            setLoadingAction("");
        }
    };

    return (
        <section className="producer-card">
            <div className="producer-header">
                <h1>{title}</h1>
                {description && <p>{description}</p>}
            </div>

            <div className="producer-actions-list">
                {actions.map((action) => (
                    <div key={action.label} className="producer-action-group">
                        <h3 className="action-title">{action.label}</h3>
                        
                        {action.fields ? (
                            <div className="action-fields">
                                {action.fields.map((field) => (
                                    <div key={field.name} className="field-group">
                                        <label htmlFor={`${action.label}-${field.name}`} className="field-label">
                                            {field.label}
                                        </label>
                                        <input
                                            id={`${action.label}-${field.name}`}
                                            type="text"
                                            value={formData[action.label]?.[field.name] || ""}
                                            onChange={(e) => handleFieldChange(action.label, field.name, e.target.value)}
                                            placeholder={field.placeholder || ""}
                                            className="field-input"
                                        />
                                    </div>
                                ))}
                            </div>
                        ) : null}

                        <button
                            onClick={() => sendMessage(action)}
                            className="producer-button"
                            disabled={loadingAction === action.label}
                        >
                            {loadingAction === action.label ? "Enviando..." : action.label}
                        </button>
                    </div>
                ))}
            </div>

            {status && (
                <div className="producer-status">
                    <p>{status}</p>
                </div>
            )}
        </section>
    );
}