package com.example.demo.section10.quiz.manage;

import com.example.demo.section10.quiz.Quiz;

public interface QuizService {
    Iterable<Quiz> selectAll();

    Quiz selectOneRandomQuiz();

    Boolean checkQuiz(Integer id, Boolean myAnswer);

    Quiz insertQuiz(QuizRequestDto requestDto);

    Quiz updateQuiz(Integer idx, QuizRequestDto requestDto);

    boolean deleteQuiz(Integer idx);
}
