package org.example;

import java.util.ArrayList;

public class Question {

    private final String text;

    private final ArrayList<String> answers;

    private final int trueAnswer;

    public Question(String text, ArrayList<String> answers, int trueAnswer) {
        this.text = text;
        this.answers = answers;
        this.trueAnswer = trueAnswer;
    }

    public String getText() {
        return text;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public int getTrueAnswer() {
        return trueAnswer;
    }

    public boolean isCorrectAnswer(int number) {
        return number == trueAnswer;
    }


}
