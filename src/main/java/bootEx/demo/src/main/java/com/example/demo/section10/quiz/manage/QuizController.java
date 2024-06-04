package com.example.demo.section10.quiz.manage;

import com.example.demo.section10.quiz.Quiz;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizServiceImpl quizServiceImpl;

    @PostMapping
    public Quiz insertQuiz(@Valid @RequestBody QuizRequestDto requestDto) {
        return quizServiceImpl.insertQuiz(requestDto);
    }

    @GetMapping("/list")
    public Iterable<Quiz> getQuizList() {
        return quizServiceImpl.selectAll();
    }

    @GetMapping
    public Quiz getRandomQuiz() {
        return quizServiceImpl.selectOneRandomQuiz();
    }

    @PutMapping("/{id}")
    public Quiz updateQuiz(@PathVariable int id,
                           @RequestBody QuizRequestDto requestDto) {
        return quizServiceImpl.updateQuiz(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteQuiz(@PathVariable int id) {
        return quizServiceImpl.deleteQuiz(id);
    }

    @GetMapping("/{id}/check")
    public boolean checkQuiz(@PathVariable int id,
                             @RequestParam(name = "myAnswer") boolean myAnswer) {
        return quizServiceImpl.checkQuiz(id, myAnswer);
    }
}
