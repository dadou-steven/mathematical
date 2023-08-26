package appsinc.fr.lesmaths;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        String s = "2023-08-08";
        Pattern regex = Pattern.compile("(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})");
        Matcher m = regex.matcher(s);
        if (m.matches()) {
            String year = m.group("year");
            String month = m.group("month");
            String day = m.group("day");
        }
        System.out.println(m.group());
        System.out.println(m.group("year"));
        System.out.println(m.group("month"));
        System.out.println(m.group("day"));
    }
}
