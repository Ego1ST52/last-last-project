package org.example.handlers;

import com.google.gson.Gson;
import org.example.FileUtils;
import org.example.Player;
import org.example.Question;
import org.example.Quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayHandler extends Handler {

    @Override
    public void start() {
        System.out.println("Напиите название желаемой викторины");
        Scanner scanner = new Scanner(System.in);


        Quiz quiz = getQuiz(scanner);
        ArrayList<Player> players = createPlayers(scanner);

        System.out.print("Внимание вопрос: ");
        for (Question question : quiz.getQuestions()){
            System.out.println(question.getText());
            printAnswers(question.getAnswers());
            System.out.print("Введите номер правильного ответ и укажите имя того,кто отвечал: ");
            String userAnswer = scanner.nextLine();
            String[] user = userAnswer.split(" ");
            int trueAnswer = Integer.parseInt(user[0]);
            if (trueAnswer == question.getTrueAnswer()){
                System.out.println("Правильный ответ!");
            }
            else System.out.println("Неправильный ответ :(");

//            int playerPos = players.indexOf("ндрей иванов");
  //          if (playerPos != -1) {

            }
    //        Player player = players.get(playerPos);



        }
  //  }

    private Quiz getQuiz(Scanner scanner) {
        Quiz quiz;
        while (true) {
            String quizName = scanner.nextLine();

            String fileString = FileUtils.readFile(quizName);
            if (fileString.isEmpty()) continue;

            quiz = new Gson().fromJson(fileString, Quiz.class);
            if (quiz == null) continue;
            break;
        }


        return quiz;
    }

    private void printAnswers(ArrayList<String> answers) {
        for (int i = 0; i < answers.size(); i++) {
            System.out.println((i + 1) + ") " + answers.get(i));
        }
    }

    private ArrayList<Player> createPlayers(Scanner scanner) {
        ArrayList<Player> players = new ArrayList<>();
        System.out.println("Введите имя игрока, когда игроки закончатся напишите stop: ");
        while (true) {
            String name = scanner.nextLine();
            if (name.equals("stop")) {
                break;
            }

            Player player = new Player(name,0);

            if (players.contains(player)) {
                System.out.println("Такой уже есть");
                continue;
            }

            players.add(player);
        }

        return players;
    }
}
