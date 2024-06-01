package com.example.demo.section10.quiz.manage;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuizRequestDto {
    @NotBlank
    private String question;
    @NotNull
    private boolean answer;
    @NotBlank
    private String author;
}
