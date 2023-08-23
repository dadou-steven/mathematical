package appsinc.fr.lesmaths;

public class FactorielRecur {

    public static long recursive(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * recursive(n - 1);
        }
    }

    public void factR(long result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        FactorielRecur solution = new FactorielRecur();
        solution.factR(recursive(3));
    }
}

// https://github.com/dadou-steven/python-pensee-computationnelle/blob/main/FactorielRecur.py
