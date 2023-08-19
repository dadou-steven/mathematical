package appsinc.fr.lesmaths;

import java.util.ArrayList;
import java.util.List;

public class SDeGListStatic {

    public static List<Integer> sDeGListStatic(int n) {
        List<Integer> list = new ArrayList<>();
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

    public void sequence(List<Integer> solution) {
        System.out.println(solution);
    }

    public static void main(String[] args) {
        SDeGListStatic sDeGListStatic = new SDeGListStatic();
        sDeGListStatic.sequence(sDeGListStatic(3));
    }
}
