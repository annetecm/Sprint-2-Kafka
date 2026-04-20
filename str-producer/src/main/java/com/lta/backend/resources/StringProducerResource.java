package com.lta.backend.resources;

import com.lta.backend.services.StringProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class StringProducerResource {

    @Autowired
    private StringProducerService stringProducerService;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message){
        stringProducerService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Patient Management endpoints
    @PostMapping("/patient/register")
    public ResponseEntity<?> registerPatient(@RequestBody String message){
        stringProducerService.sendPatientRegistration(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/patient/update")
    public ResponseEntity<?> updatePatient(@RequestBody String message){
        stringProducerService.sendPatientUpdate(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/patient/delete")
    public ResponseEntity<?> deletePatient(@RequestBody String message){
        stringProducerService.sendPatientDeletion(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Appointment Management endpoints
    @PostMapping("/appointment/create")
    public ResponseEntity<?> createAppointment(@RequestBody String message){
        stringProducerService.sendAppointmentCreation(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/appointment/cancel")
    public ResponseEntity<?> cancelAppointment(@RequestBody String message){
        stringProducerService.sendAppointmentCancellation(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/appointment/reschedule")
    public ResponseEntity<?> rescheduleAppointment(@RequestBody String message){
        stringProducerService.sendAppointmentRescheduling(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Patient Status View endpoints
    @PostMapping("/status/inquiry")
    public ResponseEntity<?> statusInquiry(@RequestBody String message){
        stringProducerService.sendStatusInquiry(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/status/history")
    public ResponseEntity<?> medicalHistory(@RequestBody String message){
        stringProducerService.sendMedicalHistory(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
