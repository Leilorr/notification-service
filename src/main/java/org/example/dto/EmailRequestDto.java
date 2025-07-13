package org.example.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailRequestDto {
    /**
     * Email адрес получателя
     */
    @NotBlank
    @Email
    private String to;

    /**
     * Тема письма
     */
    @NotBlank
    private String subject;

    /**
     * Текст письма
     */
    @NotBlank
    private String text;
}