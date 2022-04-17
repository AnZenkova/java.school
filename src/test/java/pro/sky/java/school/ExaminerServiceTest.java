package pro.sky.java.school;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.school.Service.ExaminerService;
import pro.sky.java.school.Service.QuestionService;
import pro.sky.java.school.ServiceImpl.ExaminerServiceImpl;
import pro.sky.java.school.ServiceImpl.JavaQuestionService;
import pro.sky.java.school.data.Question;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    private Question question = new Question("Что такое переменная?", "Переменная — это ячейка в памяти компьютера, которой можно присвоить имя и в которой можно хранить данные.");

    @Mock
    QuestionService questionService = new JavaQuestionService();

    @InjectMocks
    private ExaminerService examinerService = new ExaminerServiceImpl(questionService);

    @Test
    public void getQuestions() {
//        List<Question> questions = new ArrayList<Question>();
//        questions.add(question);

        Mockito.when(questionService.getRandomQuestion()).thenReturn(question);
        Collection<Question> question1 = examinerService.getQuestions(0);

        assertEquals(question1, question);
    }
}
