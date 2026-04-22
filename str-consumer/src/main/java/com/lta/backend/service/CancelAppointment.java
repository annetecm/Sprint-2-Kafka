package com.lta.backend.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CancelAppointment {

    public void cancelAppointment(String message) {
        log.info("[DB] Simulating opening connection to appointment database...");
        log.info("[DB] Starting transaction for appointment cancellation");
        log.info("[DB] UPDATE appointments SET status = 'CANCELLED' WHERE payload = '{}'", message);
        log.info("[DB] Transaction committed");
    }
}
