package pro.sky.java.school.ServiceImpl;

import org.springframework.stereotype.Service;
import pro.sky.java.school.exception.LargeNumberOfQuestions;
import pro.sky.java.school.service.ExaminerService;
import pro.sky.java.school.service.QuestionService;
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
    public Set<Question> getQuestions(int amount) {
        Collection<Question> a = questionService.getAll();
        System.out.println(a.size());
        if (amount > a.size()) {
            throw new LargeNumberOfQuestions("Запрошено большее количесво вопросов, чем есть в базе");
        }
        Set<Question> examine = new HashSet<>();
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

