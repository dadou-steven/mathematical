package appsinc.fr.poo.insect;

public class Insect {

    // variables d'instances, constantes, statiques et locales
    private double weight;
    private int x;
    private int y;

    public static final double DIST_WEIGHT_LOSS_FACTOR = .0001;
    public static final int DEFAULT_X = 0;
    public static final int DEFAULT_Y = 0;

    private static int population = 0;
    private static String[] FACTS = {
            "The two main groups of insects are winged and wingless",
            "There are more than 1 million insect species",
            "Insects are cold-blooded",
            "Spiders are not considered insects"
    };

    // constructeur
    public Insect(double weight) {
        this(weight, DEFAULT_X, DEFAULT_Y);
    }

    public  Insect(double weight, int x, int y) {
        this.weight = weight;
        this.x = x;
        this.y = y;
        population++;
    }

    // accesseurs et mutateurs
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getPopulation() {
        return population;
    }

    public static void setPopulation(int population) {
        Insect.population = population;
    }

    public static String[] getFACTS() {
        return FACTS;
    }

    public static void setFACTS(String[] FACTS) {
        Insect.FACTS = FACTS;
    }

    // méthodes
    public static boolean isLegalX(int newX) {
        return (newX >= 0);
    }

    public static boolean isLegalY(int newY) {
        return (newY >= 0);
    }

    public void eat(double amount) {
        System.out.println("Nibble Nibble");
        weight += amount;
    }

    public void move(int newX, int newY) {
        double distance = calculateDistance(x, y, newX, newY);
        if (distance > 0) {
            x = newX;
            y = newY;
            weight *= DIST_WEIGHT_LOSS_FACTOR * distance;
            System.out.printf("Moved %.2f units\n", distance);
        } else {
            System.out.println("Staying put");
        }
    }

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    public static String produceRandomFact() {
        int index = (int)(Math.random() * ((FACTS.length - 1) + 1));
        return FACTS[index];
    }

    public String toString() {
        return "weight : " + weight + ", x : " + x + ", y : " + y;
    }

    public void result(String solution) {
        System.out.println(solution);
    }

    // tester les méthodes
    public static void main(String[] args) {
        System.out.println("Insect Population : " + population);
        Insect insect1 = new Insect(10, 100, 90);
        System.out.println("Insect Population : " + population);
        Insect insect2 = new Insect(9.5, -300, 400);
        System.out.println("Insect Population : " + population);

        insect1.eat(2);
        insect2.eat(1);

        insect1.move(1, 10);
        insect2.move(-300, 400);

        System.out.println(produceRandomFact());

        insect1.result(insect1.toString());
        insect2.result(insect2.toString());
    }
}
