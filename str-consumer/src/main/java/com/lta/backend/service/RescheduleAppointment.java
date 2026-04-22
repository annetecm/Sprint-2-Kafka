package com.lta.backend.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class RescheduleAppointment {

    public void rescheduleAppointment(String message) {
        log.info("[DB] Simulating opening connection to appointment database...");
        log.info("[DB] Connection established successfully");

        log.info("[DB] Starting transaction for appointment rescheduling");
        log.info("[DB] UPDATE appointments SET schedule = '{}' WHERE status = 'ACTIVE'", message);
        log.info("[DB] Transaction committed");
    }
}
