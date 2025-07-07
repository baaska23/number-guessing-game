package org.example;

import java.util.*;

public class GameApplication {
    public static void main(String[] args) {
        int answer = (int) (Math.random() * 101);
        int counter = 0;
        boolean isGameOver = false;
        int maxAttempt;
        System.out.println("Welcome to the Number Guessing Game!\n" +
                "I'm thinking of a number between 1 and 100.\n" +
                "You have 5 chances to guess the correct number.\n" +
                "\n" +
                "Please select the difficulty level:\n" +
                "1. Easy (10 chances)\n" +
                "2. Medium (5 chances)\n" +
                "3. Hard (3 chances)\n" +
                "\n" +
                "Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int diffLevel = scanner.nextInt();
        Map<Integer, String> diffMap = Map.of(
                1, "Easy",
                2, "Medium",
                3, "Hard"
        );

        switch (diffLevel){
            case 1:
                maxAttempt = 10;
                break;
            case 2:
                maxAttempt = 5;
                break;
            case 3:
                maxAttempt = 3;
                break;
            default:
                maxAttempt = 5;
        }

        System.out.println("Great! You have selected the " + diffMap.get(diffLevel) + " difficulty level.\n" +
                "Let's start the game!");

        while (!isGameOver){
            System.out.println("Enter your guess: ");
            int guessNumber = scanner.nextInt();
            CalcResult result = calc(answer, guessNumber, counter, maxAttempt);
            counter = result.counter;
            isGameOver = result.isGameOver;
            maxAttempt = result.maxAttempt;
        }
    }

    public static CalcResult calc(int answer, int guessNumber, int counter, int maxAttempt){
        if (guessNumber > answer){
            System.out.println("Incorrect! The number is less than " + guessNumber);
            counter++;
        } else if (guessNumber < answer){
            System.out.println("Incorrect! The number is more than " + guessNumber);
            counter++;
        } else {
            System.out.println("Congratulations! You guessed the correct number in " + counter + " attempts.");
            return new CalcResult(counter, true, maxAttempt);
        }
        if (counter >= maxAttempt){
            System.out.println("Game over! You've used all your chances. The correct number was " + answer + ".");
            return new CalcResult(counter, true, maxAttempt);
        }

        return new CalcResult(counter, false, maxAttempt);
    }
}