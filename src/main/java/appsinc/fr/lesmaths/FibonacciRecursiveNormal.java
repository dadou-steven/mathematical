package appsinc.fr.lesmaths;

public class FibonacciRecursiveNormal {

    private int n;

    public FibonacciRecursiveNormal(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public String toString() {
        for (int i = 0; i <= getN(); i++) {
            System.out.println("fib(" + i + ") = " + fib(i));
        }
        return "\nFib de " + getN() + " est donc " + fib(getN());
    }

    public void fRN(String result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        FibonacciRecursiveNormal fibonacciRecursiveNormal = new FibonacciRecursiveNormal(101);
        fibonacciRecursiveNormal.fRN(fibonacciRecursiveNormal.toString());
    }
}

// https://github.com/dadou-steven/python-pensee-computationnelle/blob/main/FibonacciRecursiveNormal.py
