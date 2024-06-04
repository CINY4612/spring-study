package com.example.demo.section10.quiz.manage;

import com.example.demo.section10.quiz.Quiz;
import com.example.demo.section10.quiz.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;

    @Override
    public Quiz insertQuiz(QuizRequestDto requestDto) {
        Quiz quiz = new Quiz(null,
                requestDto.getQuestion(),
                requestDto.isAnswer(),
                requestDto.getAuthor());

        return quizRepository.save(quiz);
    }

    @Override
    public Iterable<Quiz> selectAll() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz selectOneRandomQuiz() {
        int randomId = quizRepository.getRandomId();
        return quizRepository.findById(randomId).orElseThrow(() -> new NullPointerException("저장된 퀴즈 정보가 없습니다."));
    }

    @Override
    public Boolean checkQuiz(Integer id, Boolean myAnswer) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new NullPointerException("저장된 퀴즈 정보가 없습니다."));
        return quiz.isAnswer() == myAnswer;
    }

    @Override
    public Quiz updateQuiz(Integer id, QuizRequestDto requestDto) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new NullPointerException("저장된 퀴즈 정보가 없습니다."));
        quiz.setQuestion(requestDto.getQuestion());
        quiz.setAnswer(requestDto.isAnswer());
        quiz.setAuthor(requestDto.getAuthor());

        return quizRepository.save(quiz);
    }

    @Override
    public boolean deleteQuiz(Integer idx) {
        Quiz quiz = quizRepository.findById(idx).orElseThrow(() -> new NullPointerException("저장된 퀴즈 정보가 없습니다."));
        quizRepository.delete(quiz);
        return true;
    }
}
