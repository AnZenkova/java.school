package pro.sky.java.school.service;

import pro.sky.java.school.data.Question;

import java.util.Collection;
import java.util.Set;

public interface ExaminerService {

    Set<Question> getQuestions(int amount);
}
