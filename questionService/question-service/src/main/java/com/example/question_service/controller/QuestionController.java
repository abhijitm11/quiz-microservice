package com.example.question_service.controller;

import com.example.question_service.model.Question;
import com.example.question_service.service.QuestionService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.create(question);
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{questionId}")
    public Question getAll(@PathVariable ObjectId questionId) {
        return questionService.getQuestionById(questionId);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable ObjectId quizId) {
        return questionService.getQuestionsOfQuiz(quizId);
    }

}
