package appsinc.fr.lesmaths;

public class TimeCalcul {
    private double second;
    private double minutes;
    private double hours;

    public TimeCalcul(double hours, double minutes, double second) {
        this.second = second;
        this.minutes = minutes;
        this.hours = hours;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public double getMinutes() {
        return minutes;
    }

    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double time() {
        return getMinutes() * 60 + getSecond();
    }

    public String toString() {
        return getMinutes() + " minutes et " + getSecond() + " seconde(s) donne " + time() + " secondes. ";
    }

    public void result(String solution) {
        System.out.println(solution);
    }

    public static void main(String[] args) {
        TimeCalcul timeCalcul = new TimeCalcul(0, 3, 2);
        timeCalcul.result(timeCalcul.toString());
    }
}
