package com.example.demo.section10.quiz.manage;

import com.example.demo.section10.quiz.Quiz;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz/manage")
@RequiredArgsConstructor
public class QuizManageController {
    private final QuizManageService quizManageService;

    @PostMapping
    public Quiz setUpQuiz(@Valid @RequestBody QuizRequestDto requestDto) {
        return quizManageService.saveQuiz(requestDto);
    }

    @GetMapping
    public Iterable<Quiz> getQuizList() {
        return quizManageService.getQuizList();
    }

    @GetMapping("/{idx}")
    public Quiz getQuiz(@PathVariable int idx) {
        return quizManageService.getQuiz(idx);
    }

    @PutMapping("/{idx}")
    public Quiz updateQuiz(@PathVariable int idx,
                           @RequestBody QuizRequestDto requestDto) {
        return quizManageService.updateQuiz(idx, requestDto);
    }

    @DeleteMapping("/{idx}")
    public boolean deleteQuiz(@PathVariable int idx) {
        return quizManageService.deleteQuiz(idx);
    }
}
