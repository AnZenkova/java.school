package pro.sky.java.school;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.school.ServiceImpl.JavaQuestionService;
import pro.sky.java.school.service.ExaminerService;
import pro.sky.java.school.ServiceImpl.ExaminerServiceImpl;
import pro.sky.java.school.data.Question;
import pro.sky.java.school.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.anyInt;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    private Question question = new Question("Что такое переменная?", "Переменная — это ячейка в памяти компьютера, которой можно присвоить имя и в которой можно хранить данные.");
    private QuestionService questionService = new JavaQuestionService();
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void getQuestions() {
        Set<Question> questions = new HashSet<>();
        questions.add(question);

        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(question);

        assertEquals(questions, examinerService.getQuestions(0));
    }
}
