package appsinc.fr.lesmaths;

public class FactorielIter {

    private int n;

    public FactorielIter(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public long factoriel() {
        long fact = 1;
        while (getN() > 1) {
            fact *= getN();
            n -= 1;
        }
        return fact;
    }

    public static long factoriel(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public String toString() {
        return "Factoriel Instance : " + factoriel() + "\nFactoriel Statique : " + factoriel(3);
    }

    public void result(String fact) {
        System.out.println(fact);
    }

    public static void main(String[] args) {
        FactorielIter solution = new FactorielIter(3);
        solution.result(solution.toString());
    }
}

// https://github.com/dadou-steven/python-pensee-computationnelle/edit/main/FactorielIter.py
