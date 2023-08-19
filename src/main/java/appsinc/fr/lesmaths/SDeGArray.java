package appsinc.fr.lesmaths;

public class SDeGArray { // Séquence de grêlon, array ou tableau, en Python list.

    private int[] a;
    private int i;
    private int n;

    public SDeGArray(int[] a, int i, int n) {
        this.a = a;
        this.i = i;
        this.n = n;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int sequence() {
        while (n != 1) {
            System.out.println(a[i] = n);
            i++;
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }
        return a[i] = n;
    }

    public void result(int solution) {
        System.out.println(solution);
    }

    public static void main(String[] args) {
        SDeGArray sDeGArray = new SDeGArray(new int[100], 0, 3);
        sDeGArray.result(sDeGArray.sequence());
    }
}

// https://github.com/dadou-steven/python-pensee-computationnelle/blob/main/SDeGList.py
