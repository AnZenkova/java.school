package pro.sky.java.school.serviceImpl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.java.school.data.Question;
import pro.sky.java.school.service.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@Component("Math")
public class MathQuestionService implements QuestionService {

    Map<Integer, Question> mathQuestion = new HashMap<>(Map.of(
            1, new Question("Фигура, образованная двумя лучами с общим началом?", "Угол."),
            2, new Question("Сумма длин всех сторон многоугольника?","Периметр."),
            3, new Question("Не положительное и неотрицательное число?","Нуль"),
            4, new Question("Прямая, имеющая с окружностью две общие точки?","Секущая."),
            5, new Question("График линейной функции?","Прямая"),
            6, new Question("График квадратичной функции?","Парабола")
    ));
    @Override
    public Question add(String question, String answer) {
        Question questionNew = new Question(question, answer);
        return add(questionNew);
    }

    @Override
    public Question add(Question question) {
        if (mathQuestion.containsValue(question)) {
            throw new RuntimeException("Данный вопрос уже существует");
        }
        int key = mathQuestion.size() + 1;
        mathQuestion.put(key, question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        int key = 0;
        for (int k : mathQuestion.keySet()) {
            if (mathQuestion.get(k).equals(question)) {
                key = k;
            }
        }
        if (key == 0) {
            throw new RuntimeException("Данного вопроса не существует");
        }
        mathQuestion.remove(key);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(mathQuestion.values());
    }

    @Override
    public Question getRandomQuestion() {
        java.util.Random random = new java.util.Random();
        Integer key = random.nextInt(mathQuestion.size());
        return mathQuestion.get(key);
    }
}
