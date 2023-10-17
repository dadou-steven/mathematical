package appsinc.fr.poo.canine;

import appsinc.fr.poo.car.Groomable;

public class Dog extends Canine implements Groomable {
    protected String name;

    public Dog(String name, double size) {
        super(size);
        this.name = name;
    }

    public void fetch() {
        System.out.println("Run");
        System.out.println("Clinch");
        System.out.println("Return");
    }

    public boolean equals(Object o) {
        if (!(o instanceof Dog doggy)) {
            return false;
        }
        return ((doggy.size == size) && (doggy.name.equals(name)));
    }

    public static void main(String[] args) {
        Dog spot = new Dog("Spot", 9.6);
        spot.bark();

        Dog dog1 = new Dog("Spot", 9.6);
        Dog dog2 = new Dog("Spot", 9.6);
        System.out.println(dog1.equals(dog2));
    }

    public void groom() {
    }
}
