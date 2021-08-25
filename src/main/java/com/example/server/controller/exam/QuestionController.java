package com.example.server.controller.exam;

import com.example.server.model.exam.Question;
import com.example.server.model.exam.Quiz;
import com.example.server.service.exam.QuestionService;
import com.example.server.service.exam.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;


    // add question
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //update

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    // get all question of any quiz
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid) {
//        Quiz quiz = new Quiz();
//        quiz.setQId(qid);
//        Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);

        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions =  quiz.getQuestions();
        List list = new ArrayList<>(questions);
        if(list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
            list = list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    // get all question of any quiz
    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionOfQuizAdmin(@PathVariable("qid") Long qid) {
//        Quiz quiz = new Quiz();
//        quiz.setQId(qid);
//        Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);

//        Quiz quiz = this.quizService.getQuiz(qid);
//        Set<Question> questions =  quiz.getQuestions();
//        List list = new ArrayList<>(questions);
//        if(list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
//            list = list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
//        }
//        Collections.shuffle(list);
        Quiz quiz = new Quiz();
        quiz.setQId(qid);
        Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionsOfQuiz);
//        return ResponseEntity.ok(list);
    }



    // get sigle question

    @GetMapping("/{qid}")
    public Question get(@PathVariable("qid") Long qid) {
        return this.questionService.getQuestion(qid);
    }

    //delete
    @DeleteMapping("/{id}")
    public  void delete(@PathVariable("id") Long id) {
        this.questionService.deleteQuestion(id);
    }
}
