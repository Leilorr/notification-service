package org.example.controller;

import org.example.dto.EmailRequestDto;
import org.example.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final EmailService emailService;

    /**
     * Отправляет email уведомление
     * @param emailRequest запрос на отправку email
     * @return ResponseEntity с кодом 200 в случае успеха
     */
    @PostMapping("/email")
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody EmailRequestDto emailRequest) {
        emailService.sendEmail(
                emailRequest.getTo(),
                emailRequest.getSubject(),
                emailRequest.getText()
        );
        return ResponseEntity.ok().build();
    }
}