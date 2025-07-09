package org.example;

import java.io.IOException;
import java.util.*;

public class GameApplication {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the Number Guessing Game!\nI'm thinking of a number between 1 and 100.");
        Scanner scanner = new Scanner(System.in);
        NumberGuessingGame game = new NumberGuessingGame(scanner);
        game.selectDifficulty();
        game.play();
    }
}