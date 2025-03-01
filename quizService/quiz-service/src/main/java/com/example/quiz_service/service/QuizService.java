package com.example.quiz_service.service;

import com.example.quiz_service.model.Quiz;
import org.bson.types.ObjectId;

import java.util.List;

public interface QuizService {
    Quiz createQuiz(Quiz quiz);

    List<Quiz> findAll();

    Quiz findById(ObjectId id);
}
