package singleton;

import java.util.Random;

public class GuessGame {
    private int currentNumber = Integer.MAX_VALUE;

    private static GuessGame instance = new GuessGame();

    private GuessGame() {
        this.currentNumber = new Random().nextInt(11);
    }

    public static GuessGame getInstance() {
        if (instance == null) {
            instance = new GuessGame();
        }

        return instance;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public synchronized void play(String player) {
        for (int i = 0; i < 10; i++) {
            if (new Random().nextInt(11) == instance.getCurrentNumber()) {
                System.out.println("Player " + player + " has won, the number is - " + instance.getCurrentNumber());
                return;
            } else System.out.println(player + " Wrong!");
        }

        System.out.println("Player " + player + " has lost...");
    }

    public static void main(String[] args) {
        GuessGame g1 = getInstance();
        GuessGame g2 = getInstance();

        if (g1 == g2) System.out.println("Singleton");

        Thread t1 = new Thread(() -> g1.play("Player 1"));
        Thread t2 = new Thread(() -> g1.play("Player 2"));

        t1.start();
        t2.start();
    }

}
