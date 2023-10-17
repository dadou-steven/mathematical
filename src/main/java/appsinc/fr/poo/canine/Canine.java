package appsinc.fr.poo.canine;

import appsinc.fr.poo.car.Groomable;

public abstract class Canine implements Groomable {
    protected double size;

    public Canine(double size) {
        this.size = size;
    }

    public void bark() {
        System.out.println("woof woof");
    }

    public abstract void groom();
}
