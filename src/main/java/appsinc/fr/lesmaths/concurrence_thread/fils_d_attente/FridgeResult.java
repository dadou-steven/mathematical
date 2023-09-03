package appsinc.fr.lesmaths.concurrence_thread.fils_d_attente;

public class FridgeResult {

    private final int drinksTakenOrAdded;
    private final int drinksLeftInFridge;

    public FridgeResult(int drinksTakenOrAdded, int drinksLeftInFridge) {
        this.drinksTakenOrAdded = drinksTakenOrAdded;
        this.drinksLeftInFridge = drinksLeftInFridge;
    }

    @Override
    public String toString() {
        return (drinksTakenOrAdded >= 0 ? "tou took " : " you put in ")
                + Math.abs(drinksTakenOrAdded) + " drink, fridge has "
                + drinksLeftInFridge + " left";
    }
}
