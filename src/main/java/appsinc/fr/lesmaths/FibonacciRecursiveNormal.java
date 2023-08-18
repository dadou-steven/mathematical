package appsinc.fr.lesmaths;

public class FibonacciRecursiveNormal {

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public String toString() {
        for (int i = 0; i < 101; i++) {
            System.out.println("fib(" + i + ") = " + fib(i));
        }
        return null;
    }

    public void fRN(String result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        FibonacciRecursiveNormal fibonacciRecursiveNormal = new FibonacciRecursiveNormal();
        fibonacciRecursiveNormal.fRN(fibonacciRecursiveNormal.toString());
    }
}

// https://github.com/dadou-steven/python-pensee-computationnelle/blob/main/FibonacciRecursiveNormal.py
