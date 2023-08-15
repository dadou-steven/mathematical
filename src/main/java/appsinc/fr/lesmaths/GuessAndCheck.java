package appsinc.fr.lesmaths;

public class GuessAndCheck {

    // déclaration de variables

    private int print;
    private static final int hi = 100;
    private static final int lo = 0;
    private static final boolean guessed = false;

    // constructeur

    public GuessAndCheck(int print) {
        this.print = print;
    }

    // accesseurs et mutateurs

    public int getPrint() {
        return print;
    }

    public void setPrint(int print) {
        this.print = print;
    }

    // méthodes
}

// https://github.com/dadou-steven/python-pensee-computationnelle/blob/main/GuessAndCheck.py
