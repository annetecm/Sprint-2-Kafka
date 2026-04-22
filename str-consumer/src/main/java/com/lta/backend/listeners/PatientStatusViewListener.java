package com.lta.backend.listeners;

import com.lta.backend.service.MedicalHistory;
import com.lta.backend.service.StatusInquiry;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class PatientStatusViewListener {

    @Autowired
    private StatusInquiry statusInquiry;
    @Autowired
    private MedicalHistory medicalHistory;

    // Partition 0: Status Inquiry
    @KafkaListener(groupId = "patient-status-group",
            topicPartitions = @TopicPartition(topic = "patient-status-view", partitions = {"0"}),
            containerFactory = "validMessageContainerFactory")
    public void listenStatusInquiry(String message) {
        log.info(" [CONSULTA DE ESTADO] ::: {}", message);
        statusInquiry.queryStatus(message);
    }

    // Partition 1: Medical History
    @KafkaListener(groupId = "patient-status-group",
            topicPartitions = @TopicPartition(topic = "patient-status-view", partitions = {"1"}),
            containerFactory = "validMessageContainerFactory")
    public void listenMedicalHistory(String message) {
        log.info(" [HISTORIAL MÉDICO] ::: {}", message);
        medicalHistory.queryMedicalHistory(message);
    }
}
