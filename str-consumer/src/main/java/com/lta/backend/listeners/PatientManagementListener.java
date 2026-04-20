package com.lta.backend.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class PatientManagementListener {

    // Partition 0: Patient Registration
    @KafkaListener(groupId = "patient-group",
            topicPartitions = @TopicPartition(topic = "patient-management", partitions = {"0"}),
            containerFactory = "validMessageContainerFactory")
    public void listenPatientRegistration(String message) {
        log.info(" [REGISTRO DE PACIENTE] ::: {}", message);
    }

    // Partition 1: Information Update
    @KafkaListener(groupId = "patient-group",
            topicPartitions = @TopicPartition(topic = "patient-management", partitions = {"1"}),
            containerFactory = "validMessageContainerFactory")
    public void listenPatientUpdate(String message) {
        log.info(" [ACTUALIZACIÓN DE PACIENTE] ::: {}", message);
    }

    // Partition 2: Record Deletion
    @KafkaListener(groupId = "patient-group",
            topicPartitions = @TopicPartition(topic = "patient-management", partitions = {"2"}),
            containerFactory = "validMessageContainerFactory")
    public void listenPatientDeletion(String message) {
        log.info(" [ELIMINACIÓN DE PACIENTE] ::: {}", message);
    }
}
