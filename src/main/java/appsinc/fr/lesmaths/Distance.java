package appsinc.fr.lesmaths;

public class Distance {

    private int x;
    private int y;

    public Distance(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance(double otherX, double otherY) {
        double x_diff_sq = Math.pow((x - otherX), 2);
        double y_diff_sq = Math.pow((y - otherY), 2);
        return Math.pow((x_diff_sq + y_diff_sq), 0.5);
    }

    public void result(double solution) {
        System.out.println(solution);
    }

    // https://github.com/dadou-steven/python-pensee-computationnelle/edit/main/Distance.py

    public static void main(String[] args) {
        Distance solution = new Distance(3, 4);
        solution.result(solution.distance(0, 0));
    }
}
