package org.example.service;

public interface EmailService {
    /**
     * Отправляет email
     * @param to адрес получателя
     * @param subject тема письма
     * @param text содержание письма
     */
    void sendEmail(String to, String subject, String text);
}