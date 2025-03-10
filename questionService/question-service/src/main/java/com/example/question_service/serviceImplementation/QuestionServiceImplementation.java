package com.example.question_service.serviceImplementation;

import com.example.question_service.model.Question;
import com.example.question_service.repository.QuestionRepository;
import com.example.question_service.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuestionServiceImplementation implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(String questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    @Override
    public List<Question> getQuestionsOfQuiz(String id) {
        log.info("id: {}", id.getClass());
        Query query = new Query();
        query.addCriteria(Criteria.where("quizId").is(id));
        return mongoTemplate.find(query, Question.class);
    }
}
