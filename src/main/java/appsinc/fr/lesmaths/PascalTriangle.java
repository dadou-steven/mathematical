package appsinc.fr.lesmaths;

public class PascalTriangle {

    private final int n;
    private final int k;
    public PascalTriangle(int n, int k) {
        this.n = n;
        this.k = k;
    }

    public int PascalT() {
        return n / k();
    }

    private int k() {
        return n - k;
    }

    public String toString() {
        return "Le triangle pascal de " + n + " est " + PascalT();
    }

    public void PTriangle(String result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle(2, 2);
        pascalTriangle.PTriangle(pascalTriangle.toString());
    }
}
