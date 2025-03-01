package com.example.quiz_service.controller;

import com.example.quiz_service.model.Quiz;
import com.example.quiz_service.service.QuizService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @GetMapping
    public List<Quiz> getAllQuiz() {
        return quizService.findAll();
    }

    @GetMapping("/id/{id}")
    public Quiz findQuizById(@PathVariable ObjectId id) {
        return quizService.findById(id);
    }

}
