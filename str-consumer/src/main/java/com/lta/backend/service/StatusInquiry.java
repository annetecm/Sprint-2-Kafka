package com.lta.backend.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class StatusInquiry {

    public void queryStatus(String message) {
        log.info("[DB] Simulating opening connection to patient database...");

        log.info("[DB] Executing status inquiry query");
        log.info("[DB] SELECT status FROM patients WHERE payload = '{}'", message);
        log.info("[DB] Query executed successfully");
    }
}
