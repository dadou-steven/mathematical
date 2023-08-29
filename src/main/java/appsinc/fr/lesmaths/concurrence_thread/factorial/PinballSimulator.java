package appsinc.fr.lesmaths.concurrence_thread.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PinballSimulator {
    private static PinballSimulator simulator = null;
    public static Map<Integer, Boolean> cache = new HashMap<>();
    private List<Ball> ballsInPlay;
    private Flipper leftFlipper;
    private Flipper rightFlipper;
    private int highScore;

    public PinballSimulator() {
    }

    /**
     * Méthode pinball
     * @param simulator le ...
     */
    public static void setSimulator(PinballSimulator simulator) {
        PinballSimulator.simulator = simulator;
    }

    public static boolean isPrime(int x) {
        if (cache.containsKey(x)) {
            return cache.get(x);
        }
        boolean answer = BigInteger.valueOf(x).isProbablePrime(100);
        cache.put(x, answer);
        return answer;
    }

    public void simulate() {
        int numberOfLives = 3;
        List<Ball> ballsInPlay = new ArrayList<>();

        new Thread(new Runnable() {
            public void run() {
                ballsInPlay.add(new Ball());
            }
        }).start();
    }

    public String toString() {
        return "isPrime : " + isPrime(4);
    }

    public void result(String solution) {
        System.out.println(solution);
    }

    public static void main(String[] args) {
        PinballSimulator pinballSimulator = new PinballSimulator();
        pinballSimulator.result(pinballSimulator.toString());
    }
}
