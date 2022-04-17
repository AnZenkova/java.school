package pro.sky.java.school.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.school.Service.QuestionService;
import pro.sky.java.school.data.Question;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping("/add")
    public String addQuestion(@RequestParam String question,
                              @RequestParam String answer) {
        return questionService.add(question, answer) + " Добавлен";
    }

    @RequestMapping("/remove")
    public String removeQuestion(@RequestParam String question,
                                 @RequestParam String answer) {
        Question questionNew = new Question(question, answer);
        return questionService.remove(questionNew) + " Удален";
    }

    @RequestMapping("")
    public String addQuestion() {
        return String.valueOf(questionService.getAll());
    }
}

