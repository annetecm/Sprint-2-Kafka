package com.lta.backend.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UpdatePatient {

    public void updatePatient(String message) {
        log.info("[DB] Simulating opening connection to patient database...");

        log.info("[DB] Starting transaction for patient update");
        log.info("[DB] UPDATE patients SET payload = '{}' WHERE status = 'ACTIVE'", message);
        log.info("[DB] Transaction committed");
    }
}
