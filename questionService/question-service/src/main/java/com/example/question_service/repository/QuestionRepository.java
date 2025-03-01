package com.example.question_service.repository;

import com.example.question_service.model.Question;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<Question, ObjectId> {
    List<Question> findByQuizId(ObjectId quizId);
}
