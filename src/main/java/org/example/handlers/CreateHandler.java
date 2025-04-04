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
        System.out.println("Добро пожаловать в прорграмму по созданию и проигрыванию викторин,вводите вопросы которые хотите задать участникам,когда вопросы закончатся напишите exit");

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

            String rawAnswer = scanner.nextLine();

            //
            questions.add(new Question(rawAnswer, a));

        }
        return questions;
    }
}
