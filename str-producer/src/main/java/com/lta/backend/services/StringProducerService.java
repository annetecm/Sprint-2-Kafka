package com.lta.backend.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StringProducerService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("str-topic",message).whenComplete((result,ex) -> {
           if(ex != null){
               log.error("Error, al enviar el mensaje: {}",ex.getMessage());
           }
           log.info("Mensaje enviado con éxito: {}",result.getProducerRecord().value());
           log.info("Particion {}, Offset {}", result.getRecordMetadata().partition(),result.getRecordMetadata().offset());
        });
    }

    // Patient Management - Partition 0: Patient Registration
    public void sendPatientRegistration(String message){
        kafkaTemplate.send("patient-management", 0, null, message).whenComplete((result,ex) -> {
           if(ex != null){
               log.error("Error al registrar paciente: {}",ex.getMessage());
               return;
           }
           log.info("Registro de paciente enviado: {}",result.getProducerRecord().value());
           log.info("Particion {}, Offset {}", result.getRecordMetadata().partition(),result.getRecordMetadata().offset());
        });
    }

    // Patient Management - Partition 1: Information Update
    public void sendPatientUpdate(String message){
        kafkaTemplate.send("patient-management", 1, null, message).whenComplete((result,ex) -> {
           if(ex != null){
               log.error("Error al actualizar paciente: {}",ex.getMessage());
               return;
           }
           log.info("Actualización de paciente enviada: {}",result.getProducerRecord().value());
           log.info("Particion {}, Offset {}", result.getRecordMetadata().partition(),result.getRecordMetadata().offset());
        });
    }

    // Patient Management - Partition 2: Record Deletion
    public void sendPatientDeletion(String message){
        kafkaTemplate.send("patient-management", 2, null, message).whenComplete((result,ex) -> {
           if(ex != null){
               log.error("Error al eliminar paciente: {}",ex.getMessage());
               return;
           }
           log.info("Eliminación de paciente enviada: {}",result.getProducerRecord().value());
           log.info("Particion {}, Offset {}", result.getRecordMetadata().partition(),result.getRecordMetadata().offset());
        });
    }

    // Appointment Management - Partition 0: Appointment Creation
    public void sendAppointmentCreation(String message){
        kafkaTemplate.send("appointment-management", 0, null, message).whenComplete((result,ex) -> {
           if(ex != null){
               log.error("Error al crear cita: {}",ex.getMessage());
               return;
           }
           log.info("Creación de cita enviada: {}",result.getProducerRecord().value());
           log.info("Particion {}, Offset {}", result.getRecordMetadata().partition(),result.getRecordMetadata().offset());
        });
    }

    // Appointment Management - Partition 1: Cancellation
    public void sendAppointmentCancellation(String message){
        kafkaTemplate.send("appointment-management", 1, null, message).whenComplete((result,ex) -> {
           if(ex != null){
               log.error("Error al cancelar cita: {}",ex.getMessage());
               return;
           }
           log.info("Cancelación de cita enviada: {}",result.getProducerRecord().value());
           log.info("Particion {}, Offset {}", result.getRecordMetadata().partition(),result.getRecordMetadata().offset());
        });
    }

    // Appointment Management - Partition 2: Rescheduling
    public void sendAppointmentRescheduling(String message){
        kafkaTemplate.send("appointment-management", 2, null, message).whenComplete((result,ex) -> {
           if(ex != null){
               log.error("Error al reprogramar cita: {}",ex.getMessage());
               return;
           }
           log.info("Reprogramación de cita enviada: {}",result.getProducerRecord().value());
           log.info("Particion {}, Offset {}", result.getRecordMetadata().partition(),result.getRecordMetadata().offset());
        });
    }

    // Patient Status View - Partition 0: Status Inquiry
    public void sendStatusInquiry(String message){
        kafkaTemplate.send("patient-status-view", 0, null, message).whenComplete((result,ex) -> {
           if(ex != null){
               log.error("Error al consultar estado: {}",ex.getMessage());
               return;
           }
           log.info("Consulta de estado enviada: {}",result.getProducerRecord().value());
           log.info("Particion {}, Offset {}", result.getRecordMetadata().partition(),result.getRecordMetadata().offset());
        });
    }

    // Patient Status View - Partition 1: Medical History
    public void sendMedicalHistory(String message){
        kafkaTemplate.send("patient-status-view", 1, null, message).whenComplete((result,ex) -> {
           if(ex != null){
               log.error("Error al consultar historial médico: {}",ex.getMessage());
               return;
           }
           log.info("Consulta de historial médico enviada: {}",result.getProducerRecord().value());
           log.info("Particion {}, Offset {}", result.getRecordMetadata().partition(),result.getRecordMetadata().offset());
        });
    }
}
