package pro.sky.java.school.Service;

import pro.sky.java.school.data.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
