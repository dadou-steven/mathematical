package appsinc.fr.lesmaths.concurrence_thread.factorial;

import java.math.BigInteger;

public class FactorialThread {
    /**
     * Computes n! and prints it on standard output
     * @param n must be >= 0
     */
    private static void computeFact(final int n) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= n; ++i) {
            System.out.println("working on fact " + n);
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println("fact(" + n + ") = " + result);
    }

    public static void main(String[] args) {
        computeFact(98);
        new Thread(new Runnable() {
            public void run() {
                computeFact(99);
            }
        }).start();
        computeFact(100);
    }
}
