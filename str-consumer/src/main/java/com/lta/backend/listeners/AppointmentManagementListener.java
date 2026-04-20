package com.lta.backend.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class AppointmentManagementListener {

    // Partition 0: Appointment Creation
    @KafkaListener(groupId = "appointment-group",
            topicPartitions = @TopicPartition(topic = "appointment-management", partitions = {"0"}),
            containerFactory = "validMessageContainerFactory")
    public void listenAppointmentCreation(String message) {
        log.info(" [CREACIÓN DE CITA] ::: {}", message);
    }

    // Partition 1: Cancellation
    @KafkaListener(groupId = "appointment-group",
            topicPartitions = @TopicPartition(topic = "appointment-management", partitions = {"1"}),
            containerFactory = "validMessageContainerFactory")
    public void listenAppointmentCancellation(String message) {
        log.info(" [CANCELACIÓN DE CITA] ::: {}", message);
    }

    // Partition 2: Rescheduling
    @KafkaListener(groupId = "appointment-group",
            topicPartitions = @TopicPartition(topic = "appointment-management", partitions = {"2"}),
            containerFactory = "validMessageContainerFactory")
    public void listenAppointmentRescheduling(String message) {
        log.info(" [REPROGRAMACIÓN DE CITA] ::: {}", message);
    }
}
