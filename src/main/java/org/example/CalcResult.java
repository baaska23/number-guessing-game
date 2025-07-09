package org.example;

public class CalcResult {
    public final boolean isQuit;
    public int counter;
    public boolean isGameOver;
    public int maxAttempt;

    public CalcResult(int counter, boolean isGameOver, int maxAttempt, boolean isQuit) {
        this.counter = counter;
        this.isGameOver = isGameOver;
        this.maxAttempt = maxAttempt;
        this.isQuit = isQuit;
    }
}
