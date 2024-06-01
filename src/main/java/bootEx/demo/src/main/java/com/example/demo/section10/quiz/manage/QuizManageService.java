package com.example.demo.section10.quiz.manage;

import com.example.demo.section10.quiz.Quiz;
import com.example.demo.section10.quiz.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizManageService {
    private final QuizRepository quizRepository;

    public Quiz saveQuiz(QuizRequestDto requestDto) {
        Quiz quiz = new Quiz(null,
                requestDto.getQuestion(),
                requestDto.isAnswer(),
                requestDto.getAuthor());

        return quizRepository.save(quiz);
    }

    public Iterable<Quiz> getQuizList() {
        return quizRepository.findAll();
    }

    public Quiz getQuiz(Integer idx) {
        return quizRepository.findById(idx).orElseThrow(() -> new NullPointerException("저장된 퀴즈 정보가 없습니다."));
    }

    public Quiz updateQuiz(Integer idx, QuizRequestDto requestDto) {
        Quiz quiz = getQuiz(idx);
        quiz.setQuestion(requestDto.getQuestion());
        quiz.setAnswer(requestDto.isAnswer());
        quiz.setAuthor(requestDto.getAuthor());

        return quizRepository.save(quiz);
    }

    public boolean deleteQuiz(Integer idx) {
        Quiz quiz = quizRepository.findById(idx).orElseThrow(() -> new NullPointerException("저장된 퀴즈 정보가 없습니다."));
        quizRepository.delete(quiz);
        return true;
    }
}
