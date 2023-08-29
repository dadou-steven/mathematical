package appsinc.fr.lesmaths.concurrence_thread;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return s1.compareTo(s2);
        }
        return s1.length() - s2.length();
    }

    public void result(int solution) {
        System.out.println(solution);
    }

    public static void main(String[] args) {
        StringLengthComparator stringLengthComparator = new StringLengthComparator();
        stringLengthComparator.result(stringLengthComparator.compare("dadou", "loup"));

        SortedSet<String> strings = new TreeSet<>(List.of("Yolanda", "Zach", "Alice", "Bob"));
        System.out.println(strings);

        new Thread(() -> System.out.println("Bonjour depuis un thread !")).start();
    }
}
