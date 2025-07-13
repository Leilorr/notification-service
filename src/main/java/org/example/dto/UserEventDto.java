package org.example.dto;

import lombok.Data;

@Data
public class UserEventDto {
    /**
     * Тип события (CREATED/DELETED)
     */
    private String eventType;

    /**
     * Email пользователя
     */
    private String email;

    /**
     * Имя пользователя
     */
    private String name;
}