package appsinc.fr.lesmaths.concurrence_thread.fils_d_attente;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ManyThirstyPeople {

    private static final int QUEUE_SIZE = 100;
    private static final int N = 100;

    public static void main(String[] args) {

        BlockingQueue<Integer> requests = new ArrayBlockingQueue<>(QUEUE_SIZE);
        BlockingQueue<FridgeResult> replies = new ArrayBlockingQueue<>(QUEUE_SIZE);
        DrinksFridge fridge = new DrinksFridge(requests, replies);
        fridge.start();

        try {
            requests.put(-N);
            System.out.println(replies.take());

            for (int x = 1; x <= N; ++x) {
                requests.put(1);
                System.out.println("person #" + x + " is looking for a dring");
            }

            for (int x = 1; x <= N; ++x) {
                System.out.println("person #" + x + " : " + replies.take());
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("done");
        System.exit(0);
    }
}
