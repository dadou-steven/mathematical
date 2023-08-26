package appsinc.fr.lesmaths.concurrence_thread;

public class HelloRunnable  implements Runnable {
    public void run() {
        System.out.println("Bonjour depuis un thread !");
    }
}
