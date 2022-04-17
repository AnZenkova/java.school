package pro.sky.java.school.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.school.Service.ExaminerService;

@RestController
@RequestMapping("/exam/java/exam")
public class ExamController {

    ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @RequestMapping("")
    public String getQuestion(@RequestParam int amount) {
        return String.valueOf(examinerService.getQuestions(amount));
    }
}
