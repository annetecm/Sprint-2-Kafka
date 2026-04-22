package com.lta.backend.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CreateAppointment {

    public void createAppointment(String message) {
        log.info("[DB] Simulating opening connection to appointment database...");

        log.info("[DB] Starting transaction for appointment creation");
        log.info("[DB] INSERT INTO appointments(payload) VALUES ('{}')", message);
        log.info("[DB] Transaction committed");

    }
}


