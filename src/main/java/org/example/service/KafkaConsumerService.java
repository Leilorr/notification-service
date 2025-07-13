package org.example.service;

import org.example.dto.UserEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {
    private final EmailService emailService;

    /**
     * Обрабатывает события пользователей из Kafka
     * @param event событие пользователя (создание/удаление)
     */
    @KafkaListener(topics = "user-events", groupId = "notification-group")
    public void consumeUserEvent(UserEventDto event) {
        log.info("Received user event: {}", event);

        String subject = "Account Notification";
        String text;

        if ("CREATED".equals(event.getEventType())) {
            text = String.format("Здравствуйте, %s! Ваш аккаунт на сайте ваш сайт был успешно создан.",
                    event.getName());
        } else if ("DELETED".equals(event.getEventType())) {
            text = "Здравствуйте! Ваш аккаунт был удалён.";
        } else {
            log.warn("Unknown event type: {}", event.getEventType());
            return;
        }

        emailService.sendEmail(event.getEmail(), subject, text);
    }
}