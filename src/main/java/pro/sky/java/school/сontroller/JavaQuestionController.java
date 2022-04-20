package pro.sky.java.school.сontroller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.school.service.QuestionService;
import pro.sky.java.school.data.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    @Qualifier("Java")
    private QuestionService questionService;

    public JavaQuestionController(@Qualifier("Java") QuestionService questionService) {
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
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}

