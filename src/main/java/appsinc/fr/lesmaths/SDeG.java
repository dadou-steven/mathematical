package appsinc.fr.lesmaths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SDeG { // Séquence de grêlon.

    private int n;

    public SDeG(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int sequence() {
        while (n != 1) {
            System.out.println(n);
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }
        return n;
    }

    public void result(int resultG) {
        System.out.println(resultG);
    }

    public static void main(String[] args) {
        SDeG sDeG = new SDeG(3);
        sDeG.result(sDeG.sequence());
    }
}

// https://github.com/dadou-steven/python-pensee-computationnelle/blob/main/SDeG.py
