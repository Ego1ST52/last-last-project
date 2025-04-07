package org.example.handlers;

import com.google.gson.Gson;
import org.example.FileUtils;
import org.example.Question;
import org.example.Quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateHandler extends Handler {
    @Override
    public void start() {
        System.out.println("Добро пожаловать в создание викторины, напишите название викторины, далее вопросы, когда вопросы закончатся напишите exit");

        Scanner scanner = new Scanner(System.in);

        String quizName = scanner.nextLine();

        ArrayList<Question> questions = createQuestions(scanner);
        Quiz quiz = new Quiz(quizName, questions);

        String jsonString = new Gson().toJson(quiz);
        FileUtils.saveFile(quizName, jsonString);
    }

    private ArrayList<Question> createQuestions(Scanner scanner) {
        ArrayList<Question> questions = new ArrayList<>();

        while (true) {
            System.out.println("Введите вопрос:");
            String rawQuestion = scanner.nextLine();
            if (rawQuestion.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Введите 4 варианта ответа,последним ОБЯЗАТЕЛЬНО вариант который будет являтся ответом: ");

            String[] rawAnswer = new String[4];

            String rawAnswers = null;
            for (int i = 0; i < 4; i++) {
                rawAnswers = rawAnswer[i];
            }


            ArrayList<String> answer = new ArrayList<>();
            answer.add(rawAnswers);


            //
            questions.add(new Question(rawQuestion, answer, ));
            System.out.println(rawAnswer.indexOf(3));

        }
        return questions;
    }
}
