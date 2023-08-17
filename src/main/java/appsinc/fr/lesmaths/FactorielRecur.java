package appsinc.fr.lesmaths;

public class FactorielRecur {

    private int n;

    public FactorielRecur(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int factRecur() {
        return n - 1;
    }

    public int recursive() {
        if (n <= 1) {
            return 1;
        } else {
            return n * factRecur();
        }
    }

    public void factR(int result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        FactorielRecur solution = new FactorielRecur(3);
        solution.factR(solution.recursive());
    }
}
