package com.example.quiz_service.serviceImplementation;

import com.example.quiz_service.model.Question;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// @FeignClient(url = "http://localhost:8082",value = "Question-Client")
@FeignClient(name = "question-service")
public interface QuestionClient {

    @GetMapping("/questions/quiz/{quizId}")
    List<Question> getQuestionsOfQuiz(@PathVariable String quizId);

}
