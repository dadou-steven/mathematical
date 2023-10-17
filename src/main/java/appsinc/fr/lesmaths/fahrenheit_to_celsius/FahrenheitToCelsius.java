package appsinc.fr.lesmaths.fahrenheit_to_celsius;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FahrenheitToCelsius {

    private final int TEMPS_MIN = 70;
    private final int TEMPS_MAX = 90;

    public double mondayCelsius() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrer une valeur Fahrenheit : ");
        try {
            int fahrenheit = scanner.nextInt();
            System.out.print("Entrer un  jour de la semaine : ");
            String jour = scanner.next();
            boolean pluie = false;
            System.out.print("Is it raining ? (Oui ou Non) : ");
            String raining = scanner.next().toLowerCase();
            if ("Oui".startsWith(raining)) {
                pluie = true;
            }
            if ((fahrenheit >= TEMPS_MIN) && (fahrenheit <= TEMPS_MAX) && (pluie)) {
                System.out.println("Cool, Allons au parc !");
            } else if (pluie) {
                System.out.println("En plus il peut !");
            } else {
                System.out.println("Restons à la maison car le temps est mauvais !");
            }
            return (5D / 9) * (fahrenheit - 32);
        } catch (InputMismatchException e) {
            System.out.println("Désolé, that wasn't an int.");
            System.out.println("Please re-run the program again");
        }
        return 0;
    }
    public double tuesdayCelsius() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrer une autre valeur Fahrenheit : ");
        int fahrenheit = scanner.nextInt();
        System.out.print("Entrer un autre jour de la semaine : ");
        String jour = scanner.next();
        boolean pluie = false;
        System.out.print("Is it raining ? (Oui ou Non) : ");
        String raining = scanner.next().toLowerCase();
        if ("Oui".startsWith(raining)) {
            pluie = true;
        }
        if ((fahrenheit >= TEMPS_MIN) && (fahrenheit <= TEMPS_MAX) && !pluie) {
            System.out.println("Cool, Allons au parc !");
        } else if (pluie) {
            System.out.println("En plus il peut !");
        } else {
            System.out.println("Restons à la maison car le temps est mauvais !");
        }

        return (5D / 9) * (fahrenheit - 32);
    }

    public String toString() {
        return "\nLundi : " + mondayCelsius() + " °C.\nMardi : " + tuesdayCelsius() + " °C.";
    }

    public void result(String solution) {
        System.out.println(solution);
    }

    public static void main(String[] args) {
        FahrenheitToCelsius fahrenheitToCelsius = new FahrenheitToCelsius();
        fahrenheitToCelsius.result(fahrenheitToCelsius.toString());
    }
}
