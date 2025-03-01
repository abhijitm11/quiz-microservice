package com.example.question_service.service;

import com.example.question_service.model.Question;
import org.bson.types.ObjectId;

import java.util.List;

public interface QuestionService {
    Question create(Question question);

    List<Question> getAllQuestions();

    Question getQuestionById(ObjectId questionId);

    List<Question> getQuestionsOfQuiz(ObjectId quizId);
}
