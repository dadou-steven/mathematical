package appsinc.fr.lesmaths;

public class FactorielIter {

    private int n;
    private static int answer = 1;

    public FactorielIter(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int factoriel() {
        while (n > 1) {
            answer *= n;
            n -= 1;
        }
        return answer;
    }

    public void result(int fact) {
        System.out.println(fact);
    }

    public static void main(String[] args) {
        FactorielIter solution = new FactorielIter(3);
        solution.result(solution.factoriel());
    }
}

// https://github.com/dadou-steven/python-pensee-computationnelle/edit/main/FactorielIter.py
