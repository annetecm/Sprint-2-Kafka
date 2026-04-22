package com.lta.backend.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class DeletePatient {

    public void deletePatient(String message) {
        log.info("[DB] Simulating opening connection to patient database...");

        log.info("[DB] Starting transaction for patient deletion");
        log.info("[DB] DELETE FROM patients WHERE payload = '{}'", message);
        log.info("[DB] Transaction committed");
    }
}
