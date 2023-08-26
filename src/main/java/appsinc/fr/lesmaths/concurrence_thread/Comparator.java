package appsinc.fr.lesmaths.concurrence_thread;

public interface Comparator <T> {
    /**
     * Compare l'ordre de ses deux arguments
     * @param o1 argument 1
     * @param o2 argument 2
     * @return un entier...
     */
    public int compare(T o1, T o2);
}
