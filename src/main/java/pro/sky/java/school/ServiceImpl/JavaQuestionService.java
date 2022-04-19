package pro.sky.java.school.ServiceImpl;

import org.springframework.stereotype.Repository;
import pro.sky.java.school.service.QuestionService;
import pro.sky.java.school.data.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JavaQuestionService implements QuestionService {

    Map<Integer, Question> javaQuestion = new HashMap<>(Map.of(
            1, new Question("Что такое переменная?", "Переменная — это ячейка в памяти компьютера, которой можно присвоить имя и в которой можно хранить данные."),
            2, new Question("Какого типа переменные в джава бывают?","Целочисленные, вещественные, логические и символьные."),
            3, new Question("Что означает инициализация?","Инициализация — присваивание какого-то значения переменной."),
            4, new Question("Какие условные операторы вы знаете?","Конструкция if(), конструкция else, конструкция if-else, конструкция switch."),
            5, new Question("Что такое массив?","Массив — упорядоченная структура данных фиксированного размера."),
            6, new Question("Что такое метод?","Метод — блок кода, который выполняет определенную функцию и позволяет себя переиспользовать в нескольких местах без необходимости снова и снова писать один и тот же код."),
            7, new Question("Что такое статические методы?","Методы, которые принадлежат классу, не требуется иметь объект для его вызова."),
            8, new Question("Что такое нестатические методы?","Методы, которые принадлежат объекту. Для их использования нам нужно самим создать объект, инициализировать его и вызвать у этого объекта метод."),
            9, new Question("Что такое инкапсуляция?","Инкапсуляция в Java подразумевает разграничение доступа к данным и возможностям классов и объектов."),
            10, new Question("Что такое полиморфизм?","Данный принцип описывает механизм работы с разными типами объектов как с одним.")
    ));

    @Override
    public Question add(String question, String answer) {
        Question questionNew = new Question(question, answer);
        return add(questionNew);
    }

    @Override
    public Question add(Question question) {
        if (javaQuestion.containsValue(question)) {
            throw new RuntimeException("Данный вопрос уже существует");
        }
        int key = javaQuestion.size() + 1;
        javaQuestion.put(key, question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        int key = 0;
        for (int k : javaQuestion.keySet()) {
            if (javaQuestion.get(k).equals(question)) {
                key = k;
            }
        }
        if (key == 0) {
            throw new RuntimeException("Данного вопроса не существует");
        }
        javaQuestion.remove(key);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(javaQuestion.values());
    }

    @Override
    public Question getRandomQuestion() {
        java.util.Random random = new java.util.Random();
        Integer key = random.nextInt(javaQuestion.size());
        return javaQuestion.get(key);
    }
}

