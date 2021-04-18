package rev.team.PROBLEM_SERVICE.controller;

import ch.qos.logback.classic.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rev.team.PROBLEM_SERVICE.domain.entity.Question;
import rev.team.PROBLEM_SERVICE.service.QuestionService;

@RestController
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/question/{id}")
    public Question hello(@PathVariable("id") Long id){
        Question question = questionService.getQuestion(id);
        if(question == null) return new Question();
        else return question;
    }
}
