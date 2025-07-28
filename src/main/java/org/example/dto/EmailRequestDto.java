package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
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