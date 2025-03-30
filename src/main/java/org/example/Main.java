package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> question = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> trueAnswer = new ArrayList<>();
        System.out.println("Добро пожаловать в прорграмму по созданию и проигрыванию викторин,вводите вопросы которые хотите задать участникам,когда вопросы закончатся напишите exit");
        while (true) {
            System.out.println("Введите вопрос:");
            String rawQuestion = scanner.nextLine();
            if (rawQuestion.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Введите 4 варианта ответа,последним ОБЯЗАТЕЛЬНО вариант который будет являтся ответом: ");
            String rawAnswer = scanner.nextLine();
            String[] answers = rawAnswer.split(" ");
            trueAnswer.add(answers[answers.length - 1]);
            question.add(rawQuestion);
            answer.add(Arrays.toString(answers));

        }
        System.out.println("Введите имя игрока, когда игроки закончатся напишите stop: ");
        while (true){
            String name = scanner.nextLine();
            new Player(name,0);

        }

        System.out.print("Внимание вопрос: ");
        for (int i = 0; i < question.size();i++){
            System.out.println(question.get(i));
            System.out.println(answer.get(i));
            System.out.print("Введите правильный ответ и укажите имя того,кто отвечал: ");
            String userAnswer = scanner.nextLine();
            String[] user = userAnswer.split(" ");
            if (userAnswer.equalsIgnoreCase(trueAnswer.get(i))){
                System.out.println("Правильный ответ!");

            }
            else System.out.println("Неправильный ответ :(");
        }
    }
}


