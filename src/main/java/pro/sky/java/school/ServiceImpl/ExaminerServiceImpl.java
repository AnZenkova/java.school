package pro.sky.java.school.ServiceImpl;

import org.springframework.stereotype.Service;
import pro.sky.java.school.Exception.LargeNumberOfQuestions;
import pro.sky.java.school.Service.ExaminerService;
import pro.sky.java.school.Service.QuestionService;
import pro.sky.java.school.data.Question;

import java.util.*;

@Service
//@SessionScope
public class ExaminerServiceImpl implements ExaminerService {

    public QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        Collection<Question> a = questionService.getAll();
        System.out.println(a.size());
        if (amount > a.size()) {
            throw new LargeNumberOfQuestions("Запрошено большее количесво вопросов, чем есть в базе");
        }
        List<Question> examine = new ArrayList<>();
        while (examine.size() <= amount) {
            Question question = questionService.getRandomQuestion();
            if (examine.contains(question) || examine.contains(null)) {
                question = questionService.getRandomQuestion();
            }
            examine.add(question);
        }
        return examine;
    }
}

