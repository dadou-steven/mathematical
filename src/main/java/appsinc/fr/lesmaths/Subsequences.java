package appsinc.fr.lesmaths;

public class Subsequences {

    public static String subsequence(String word) {
        if (word.isEmpty()) {
            return "";
        } else {
            char firstLetter = word.charAt(0);
            String restOfWord = word.substring(1);

            String subsequenceOfRest = subsequence(restOfWord);

            StringBuilder result = new StringBuilder();
            final int withTrailingEmptyStrings = -1;
            for (String subsequence : subsequenceOfRest.split(",", withTrailingEmptyStrings)) {
                result.append(",").append(subsequence);
                result.append(",").append(firstLetter).append(subsequence);
            }
            result = new StringBuilder(result.substring(1));
            return result.toString();
        }
    }

    public void result(String solution) {
        System.out.println(solution);
    }

    public static void main(String[] args) {
        Subsequences subsequences = new Subsequences();
        subsequences.result(subsequence("Dadou"));
    }
}
