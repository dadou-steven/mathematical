package appsinc.fr.lesmaths.fahrenheit_to_celsius;

import java.util.Arrays;

public class LesTableaux {
    public static void main(String[] args) {
        double[] weekHighs = { 80, 70, 75, 69, 72, 74, 90};
        double highSum = 0;
        for (double weeHigh : weekHighs) {
            highSum += weeHigh;
        }
        double averageHighs = highSum / weekHighs.length;
        System.out.println(averageHighs + " " + highSum);

        String[] concepts = new String[5];
        concepts[0] = "abstraction";
        concepts[2] = "polymorphism";
        concepts[3] = "inheritance";
        concepts[4] = "encapsulation";
        String result = "not found";
        for (String concept : concepts) {
            if ((concept != null) && (concept.equals("polymorphism"))) {
                result = "found";
                break;
            }
        }
        System.out.println(result);

        double sum = 0;
        for (String num : args) {
            sum += Double.parseDouble(num);
        }
        double average = (args.length > 0) ? (sum / args.length) : 0;
        System.out.println("Average is : " + average);

        double[][] array2d = {{80, 70, 75}, {69, 72, 74}};
        final double MIN_TEMP = 75;
        final double MAX_TEMP = 90;
        for (double[] row : array2d) {
            for (double col : row) {
                if ((col >= MIN_TEMP) && (col <= MAX_TEMP)) {
                    System.out.println("Allons au parc !");
                }
            }
        }

        double[][] array2D = new double[2][];
        array2D[0] = new double[3];
        array2D[0][0] = 80;
        array2D[0][1] = 70;
        array2D[0][2] = 75;
        array2D[1] = new double[4];
        array2D[1][0] = 69;
        array2D[1][1] = 72;
        array2D[1][2] = 74;
        array2D[1][3] = 90;
        for (double[] row1 : array2D) {
            for (double col1 : row1) {
                if ((col1 >= MIN_TEMP) && (col1 <= MAX_TEMP)) {
                    System.out.println("Cool, allons au parc !");
                }
            }
        }

        int[] threes = {3, 6, -3, -6};
        int i = 0;
        while (i < threes.length) {
            threes[i] *= 3;
            i++;
        }
        System.out.println(Arrays.toString(threes));

        boolean x = true;
        int count = 0;
        while (x) {
            count += 3;
            if (count % 5 == 0) {
                x = false;
            }
        }
        System.out.println(count);
    }
}

