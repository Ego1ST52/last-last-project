package org.example;

import org.example.handlers.CreateHandler;
import org.example.handlers.Handler;
import org.example.handlers.PlayHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Handler handler;

        System.out.println("Введите режим (create/play)");
        while (true) {
            String nextLine = scanner.nextLine();
            if (nextLine.equals("create")) {
                handler = new CreateHandler();
                break;
            } else if (nextLine.equals("play")) {
                handler = new PlayHandler();
                break;
            }
        }
        handler.start();

    }
}


