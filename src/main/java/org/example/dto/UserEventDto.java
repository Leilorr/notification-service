package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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