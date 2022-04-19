package pro.sky.java.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.school.service.QuestionService;
import pro.sky.java.school.ServiceImpl.JavaQuestionService;
import pro.sky.java.school.data.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionServiceTest {

    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;
    private Question question5;
    private Question question6;
    private Question question7;
    private Question question8;
    private Question question9;
    private Question question10;
    private JavaQuestionService javaQuestionService;

    private QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    private void setUp() {
        question1 = new Question("Что такое переменная?", "Переменная — это ячейка в памяти компьютера, которой можно присвоить имя и в которой можно хранить данные.");
        question2 = new Question("Какого типа переменные в джава бывают?","Целочисленные, вещественные, логические и символьные.");
        question3 = new Question("Что означает инициализация?","Инициализация — присваивание какого-то значения переменной.");
        question4 = new Question("Какие условные операторы вы знаете?","Конструкция if(), конструкция else, конструкция if-else, конструкция switch.");
        question5 = new Question("Что такое массив?","Массив — упорядоченная структура данных фиксированного размера.");
        question6 = new Question("Что такое метод?","Метод — блок кода, который выполняет определенную функцию и позволяет себя переиспользовать в нескольких местах без необходимости снова и снова писать один и тот же код.");
        question7 = new Question("Что такое статические методы?","Методы, которые принадлежат классу, не требуется иметь объект для его вызова.");
        question8 = new Question("Что такое нестатические методы?","Методы, которые принадлежат объекту. Для их использования нам нужно самим создать объект, инициализировать его и вызвать у этого объекта метод.");
        question9 = new Question("Что такое инкапсуляция?","Инкапсуляция в Java подразумевает разграничение доступа к данным и возможностям классов и объектов.");
        question10 = new Question("Что такое полиморфизм?","Данный принцип описывает механизм работы с разными типами объектов как с одним.");

    }

    private List<Question> addActualList() {

        List<Question> actual = new ArrayList<Question>();

        actual.add(question1);
        actual.add(question2);
        actual.add(question3);
        actual.add(question4);
        actual.add(question5);
        actual.add(question6);
        actual.add(question7);
        actual.add(question8);
        actual.add(question9);
        actual.add(question10);
        return actual;
    }



    @Test
    public void addQuestion() {

        Question question11 = new Question("Что обозначает @Test?", "Это основная аннотация фреймворка. Ей помечаются методы, которые JUnit запустит в качестве тестов.");
        Question question12 = new Question("Что такое JUnit?", "Это основной фреймворк для модульных тестов на Java.");

        questionService.add(question11);
        questionService.add(question12);

        Collection<Question> expected = questionService.getAll();

        Collection<Question> actual = addActualList();

        actual.add(question11);
        actual.add(question12);

        assertEquals(expected, actual);
        assertThrows(RuntimeException.class, null);
    }

    @Test
    public void add() {
        String question11 = "Что обозначает @Test?";
        String answer11 = "Это основная аннотация фреймворка. Ей помечаются методы, которые JUnit запустит в качестве тестов.";

        String question12 = "Что такое JUnit?";
        String answer12 = "Это основной фреймворк для модульных тестов на Java.";

        questionService.add(question11, answer11);
        questionService.add(question12, answer12);

        Collection<Question> expected = questionService.getAll();

        Collection<Question> actual = addActualList();

        Question questionAdd1 = new Question(question11, answer11);
        Question questionAdd2 = new Question(question12, answer12);

        actual.add(questionAdd1);
        actual.add(questionAdd2);

        assertEquals(expected, actual);
    }

    @Test
    public void getAll() {

        Collection<Question> expected = questionService.getAll();

        Collection<Question> actual = addActualList();

        assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        Question question11 = new Question("Что такое переменная?", "Переменная — это ячейка в памяти компьютера, которой можно присвоить имя и в которой можно хранить данные.");
        Question question12 = new Question("Какого типа переменные в джава бывают?","Целочисленные, вещественные, логические и символьные.");

        questionService.remove(question11);
        questionService.remove(question12);

        Collection<Question> expected = questionService.getAll();

        Collection<Question> actual = addActualList();
        actual.remove(question11);
        actual.remove(question12);

        assertEquals(expected, actual);
        assertThrows(RuntimeException.class, null);
    }
}
