package com.example.quiz_service.serviceImplementation;

import com.example.quiz_service.model.Quiz;
import com.example.quiz_service.repository.QuizRepository;
import com.example.quiz_service.service.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class QuizServiceImplementation implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> findAll() {
        List<Quiz> quizzes = quizRepository.findAll();
        // Ensure the quiz is returned after modifying it
        return quizzes.stream()
                .map(quiz -> {
                    quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
                    return quiz;
                }).collect(Collectors.toList());
    }

    @Override
    public Quiz findById(String id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }
}
