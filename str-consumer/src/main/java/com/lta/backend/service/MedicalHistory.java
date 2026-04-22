package com.lta.backend.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class MedicalHistory {

    public void queryMedicalHistory(String message) {
        log.info("[DB] Simulating opening connection to patient database...");
        log.info("[DB] Connection established successfully");

        log.info("[DB] Executing medical history query");
        log.info("[DB] SELECT * FROM medical_history WHERE patient_payload = '{}'", message);
        log.info("[DB] Query executed successfully");
    }
}
