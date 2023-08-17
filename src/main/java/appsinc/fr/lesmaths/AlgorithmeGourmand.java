package appsinc.fr.lesmaths;

public class AlgorithmeGourmand {

    private String name;
    private int value;
    private int calories;

    public AlgorithmeGourmand(String name, int value, int calories) {
        this.name = name;
        this.value = value;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double density() {
        return (double) value / calories;
    }

    public String toString() {
        return "Nom : " + name + "\nPoids total : " + value + " Kg\nCalories brulées : " + calories + "Kj\nCalories perdues : " + density() + " Kj";
    }

    public void str(String solution) {
        System.out.println(solution);
    }

    public static void main(String[]args) {
        AlgorithmeGourmand solution = new AlgorithmeGourmand("Dadou", 84, 10);
        solution.str(solution.toString());
    }
}
