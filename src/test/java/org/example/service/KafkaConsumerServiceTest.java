package org.example.service;

import org.example.dto.UserEventDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class KafkaConsumerServiceTest {
    @Mock
    private EmailService emailService;

    @InjectMocks
    private KafkaConsumerService kafkaConsumerService;

    @Test
    void shouldHandleUserCreatedEvent() {
        UserEventDto event = new UserEventDto();
        event.setEventType("CREATED");
        event.setEmail("user@example.com");
        event.setName("John Doe");

        kafkaConsumerService.consumeUserEvent(event);

        verify(emailService).sendEmail(
                "user@example.com",
                "Account Notification",
                "Здравствуйте, John Doe! Ваш аккаунт на сайте ваш сайт был успешно создан."
        );
    }

    @Test
    void shouldHandleUserDeletedEvent() {
        UserEventDto event = new UserEventDto();
        event.setEventType("DELETED");
        event.setEmail("user@example.com");
        event.setName("John Doe");

        kafkaConsumerService.consumeUserEvent(event);

        verify(emailService).sendEmail(
                "user@example.com",
                "Account Notification",
                "Здравствуйте! Ваш аккаунт был удалён."
        );
    }
}