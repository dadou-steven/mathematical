package appsinc.fr.lesmaths.concurrence_thread.callbacks;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Counter {

    private BigInteger number = BigInteger.ZERO;
    private Set<NumberListener> listeners = new HashSet<>();

    public Counter() {

    }

    public synchronized BigInteger number() {
        return number();
    }

    public synchronized void increment() {
        number = number.add(BigInteger.ONE);
        callListeners();
    }

    public synchronized void addNumberListener(NumberListener listener) {
        listeners.add(listener);
    }

    public synchronized void removeNumberListener(NumberListener listener) {
        listeners.remove(listener);
    }

    private void callListeners() {
        for (NumberListener listener : listeners) {
            listener.numberReached(number);
        }
    }

    public interface NumberListener {
        public void numberReached(BigInteger number);
    }
}
