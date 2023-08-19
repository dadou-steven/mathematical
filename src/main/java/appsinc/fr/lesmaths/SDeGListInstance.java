package appsinc.fr.lesmaths;

import java.util.ArrayList;
import java.util.List;

public class SDeGListInstance {

    private List<Integer> list;
    private int n;

    public SDeGListInstance(List<Integer> list, int n) {
        this.list = list;
        this.n = n;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public List<Integer> sequence() {
        while (n != 1) {
            list.add(n);
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }
        list.add(n);
        return list;
    }

    public int maxList(int max) {
        for (int x : list) {
            max = Math.max(x, max);
        }
        return max;
    }

    public String toString() {
        return "Liste : " + sequence() + "\nMaximal : " + maxList(0);
    }

    public void result(String solution) {
        System.out.println(solution);
    }

    public static void main(String[]args) {
        SDeGListInstance sDeGListInstance = new SDeGListInstance(new ArrayList<>(), 3);
        sDeGListInstance.result(sDeGListInstance.toString());
    }
}
