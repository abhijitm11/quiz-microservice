package com.example.quiz_service.serviceImplementation;

import com.example.quiz_service.model.Quiz;
import com.example.quiz_service.repository.QuizRepository;
import com.example.quiz_service.service.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuizServiceImplementation implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz findById(ObjectId id) {
        return quizRepository.findById(id).orElse(null);
    }
}
