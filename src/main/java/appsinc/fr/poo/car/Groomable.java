package appsinc.fr.poo.car;

public interface Groomable {
    public void groom();
    default void pay() {
        System.out.println("Cha-Ching !");
    }
    static void calculateTip(double price, double percentage) {
        double rawTip = price * (percentage / 100);
    }
}
