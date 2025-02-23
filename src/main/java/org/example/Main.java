package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> question = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> trueAnswer = new ArrayList<>();
        System.out.println("Добро пожаловать в прорграмму по созданию и проигравынию викторин,вводите вопросы которые хотетите задать участникам,когда вопросы закончатся напишите exit");
        while (true) {
            System.out.println("Введите вопрос:");
            String rawQuestion = scanner.nextLine();
            if (rawQuestion.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Введите 4 варианта ответа,последним ОБЯЗАТЕЛЬНО вариант который будет являтся ответом: ");
            String rawAnswer = scanner.nextLine();
            String[] answers = rawAnswer.split(", ");
            trueAnswer.add(answers[answers.length - 1]);
            answer.add(rawAnswer);
            question.add(rawQuestion);
        }
        System.out.println("Внимание вопрос");
        while (true) {
            for (int i = 0; i < question.size(); i++) {
                System.out.println(question.get(i));
                if (i > 0) {
                    System.out.println(answer.get(i * 4));
                    System.out.println(answer.get(i * 4 + 1));
                    System.out.println(answer.get(i * 4 + 2));
                    System.out.println(answer.get(i * 4 + 3));
                }
                else
                    System.out.println(answer.get(i));
                System.out.println(answer.get(i + 1));
                System.out.println(answer.get(i + 2));
                System.out.println(answer.get(i + 3));
                System.out.println("Выберите вариант ответа: ");
                String answerFromUser = scanner.nextLine();
                if (answerFromUser.equalsIgnoreCase(trueAnswer.get(i))) {
                    System.out.println("Правильно!");
                } else {
                    System.out.println("Неправильно :(");
                }

            }
            break;
        }
        }

    }
