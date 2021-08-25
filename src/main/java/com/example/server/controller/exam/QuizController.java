package com.example.server.controller.exam;

import com.example.server.model.exam.Quiz;
import com.example.server.service.exam.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // add quizz

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    // update quizz

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    // get quizz
    @GetMapping
    public ResponseEntity<?> quizzes(){
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    //get quizz by id
    @GetMapping("/{id}")
    public Quiz quiz(@PathVariable("id") Long id){
        return this.quizService.getQuiz(id);
    }

    // delete

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.quizService.deleteQuiz(id);
    }
}
