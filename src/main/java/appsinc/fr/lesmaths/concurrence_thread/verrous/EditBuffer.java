package appsinc.fr.lesmaths.concurrence_thread.verrous;

public interface EditBuffer {

    public void insert(int position, String insertion);
    public void delete(int position, int len);
    public int length();
    public String toString();
}
