package org.example;

import java.io.*;
import java.util.*;

public class NumberGuessingGame {
    private final Scanner scanner;
    private final List<String> userList;
    private final Map<String, Integer> userScores;
    private int maxAttempt;
    private int answer;
    private int counter;
    private boolean isGameOver;
    private boolean isQuit;
    private String username;
    public static final String FILE_PATH = "/Users/clayuuganbadrakh/IdeaProjects/roadmapNumberGuessingGame/src/main/java/org/example/users.txt";

    public NumberGuessingGame(Scanner scanner) {
        this.scanner = scanner;
        this.userList = new ArrayList<>();
        this.userScores = new HashMap<>();
        this.isQuit = false;
    }

    public void selectDifficulty() {
        System.out.println("Please select the difficulty level:\n" +
                "1. Easy (10 chances)\n" +
                "2. Medium (5 chances)\n" +
                "3. Hard (3 chances)\n" +
                "\nEnter your choice: ");
        int diffLevel = scanner.nextInt();
        scanner.nextLine();
        switch (diffLevel) {
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
        System.out.println("Great! You have selected the " +
                (diffLevel == 1 ? "Easy" : diffLevel == 2 ? "Medium" : diffLevel == 3 ? "Hard" : "Medium") +
                " difficulty level.\nLet's start the game!");
    }

    public void play() throws IOException {
        long startTime = System.nanoTime();
        while (!isQuit) {
            startNewRound();
            handleUser();
            while (!isGameOver) {
                System.out.println("Enter your guess: ");
                int guessNumber = scanner.nextInt();
                scanner.nextLine();
                CalcResult result = calc(guessNumber);
                counter = result.counter;
                isGameOver = result.isGameOver;
                maxAttempt = result.maxAttempt;
                isQuit = result.isQuit;
                if (isGameOver) {
                    userScores.put(username, counter);
                }
            }
        }
        writeUser(username, counter);
        long endTime = System.nanoTime();
        long runTime = (endTime - startTime) / 1_000_000_000;
        System.out.println("You spent " + runTime + " seconds.");
        //System.out.println("All users: " + userScores);
        readUser(username, counter);
    }

    private void startNewRound() {
        answer = (int) (Math.random() * 101);
        counter = 0;
        isGameOver = false;
    }

    private void handleUser() throws IOException {
        System.out.println("Enter your username: ");
        username = scanner.nextLine();
        if (!userList.contains(username)) {
            userList.add(username);
        }
    }

    private void writeUser(String username, int counter) {
        boolean userFound = false;
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(username + ":")) {
                    int oldScore = Integer.parseInt(line.split(": ")[1]);
                    int newScore = Math.min(oldScore, counter);
                    lines.add(username + ": " + newScore);
                    userFound = true;
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(!userFound){
            lines.add(username + ": " + counter);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for(String l : lines){
                writer.write(l);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readUser(String username, int counter) {
        Map<String, Integer> userMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if(parts.length == 2){
                    userMap.put(parts[0], Integer.parseInt(parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        userMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private CalcResult calc(int guessNumber) {
        if (guessNumber > answer) {
            System.out.println("Incorrect! The number is less than " + guessNumber);
            counter++;
        } else if (guessNumber < answer) {
            System.out.println("Incorrect! The number is more than " + guessNumber);
            counter++;
        } else {
            System.out.println("Congratulations! You guessed the correct number in " + counter + " attempts.");
            System.out.println("Do you want to play another round? If so, press y");
            String ans = scanner.nextLine();
            return ans.equals("y")
                    ? new CalcResult(counter, true, maxAttempt, false)
                    : new CalcResult(counter, true, maxAttempt, true);
        }
        if (counter >= maxAttempt) {
            System.out.println("Game over! The correct number was " + answer + ".");
            System.out.println("Do you want to play another round? If so, press y OR n");
            String ans = scanner.nextLine();
            return ans.equals("y")
                    ? new CalcResult(counter, true, maxAttempt, false)
                    : new CalcResult(counter, true, maxAttempt, true);
        }
        return new CalcResult(counter, false, maxAttempt, false);
    }
}