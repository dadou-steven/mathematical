package appsinc.fr.lesmaths;

public record Duration(int mins, int secs) {

    public long getLength() {
        return  (long)mins * 60 + secs;
    }

    public void  result(long solution) {
        System.out.println(solution);
    }

    public static void main(String[] args) {
        Duration duration = new Duration(1, 2);
        duration.result(duration.getLength());
    }
}
