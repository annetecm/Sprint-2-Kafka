package com.lta.backend.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class RegisterPatient {

    public void registerPatient(String message) {
        log.info("[DB] Simulating opening connection to patient database...");
        log.info("[DB] Connection established successfully");

        log.info("[DB] Starting transaction for patient registration");
        log.info("[DB] INSERT INTO patients(payload) VALUES ('{}')", message);
        log.info("[DB] Transaction committed");
    }
}
