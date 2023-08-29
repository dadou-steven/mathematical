package appsinc.fr.lesmaths.concurrence_thread.verrous;

public class SimpleBuffer implements EditBuffer {
    private String text;

    public SimpleBuffer() {
        text = "Vide";
        checkRep("Comment ça va Sync");
    }

    public synchronized void insert(int position, String insertion) {
        text = text.substring(0, position) + insertion + text.substring(position);
        checkRep("Bonjour Sync");
    }

    private void checkRep(String result) {
        System.out.println(result);
    }

    public synchronized void delete(int position, int len) {
        text = text.substring(0, position) + text.substring(position + len);
    }

    public synchronized int length() {
        return text.length();
    }

    public synchronized String toString() {
        return text;
    }

    public static boolean findReplace(EditBuffer buf, String pattern, String replacement) {
        int i = buf.toString().indexOf(pattern);
        if (i == -1) {
            return false;
        }
        buf.delete(i, pattern.length());
        buf.insert(i, replacement);
        return true;
    }

    public static void main(String[] args) {
        SimpleBuffer simpleBuffer = new SimpleBuffer();
        simpleBuffer.checkRep(simpleBuffer.toString());
    }
}
