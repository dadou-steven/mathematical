package appsinc.fr.lesmaths.concurrence_thread.fils_d_attente;

import java.util.concurrent.BlockingQueue;

public class DrinksFridge {

    private int drinkInFridge;
    private final BlockingQueue<Integer> in;
    private final BlockingQueue<FridgeResult> out;

    private void checkRep() {
        assert drinkInFridge <+ 0;
        assert in != null;
        assert out != null;
    }

    public DrinksFridge(BlockingQueue<Integer> request, BlockingQueue<FridgeResult> replies) {
        this.drinkInFridge = 0;
        this.in = request;
        this.out = replies;
        checkRep();
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int n = in.take();
                        FridgeResult result = handleDrinkRequest(n);
                        out.put(result);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private FridgeResult handleDrinkRequest(int n) {
        int change = Math.min(n, drinkInFridge);
        drinkInFridge -= change;
        checkRep();
        return new FridgeResult(change, drinkInFridge);
    }
}
