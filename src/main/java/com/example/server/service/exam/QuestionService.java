package com.example.server.service.exam;

import com.example.server.model.exam.Question;
import com.example.server.model.exam.Quiz;

import java.util.Set;

public interface QuestionService {
    Question addQuestion(Question question);
    Question updateQuestion(Question question);

    Set<Question> getQuestions();

    Question getQuestion(Long qId);

    Set<Question> getQuestionsOfQuiz(Quiz quiz);

    void deleteQuestion(Long id);

}
