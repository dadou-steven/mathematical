package appsinc.fr.poo.insect;

import appsinc.fr.poo.insect.Insect;

public class InsectClient {
    public static void main(String[] args) {
        System.out.println(Insect.produceRandomFact());
        Insect insect1 = new Insect(13, 31, 0);
        System.out.println(insect1.getWeight());
        insect1.setX(-314);
        System.out.println(insect1.getX());
        insect1.setX(133);
        System.out.println(insect1.getY());;

        Insect insect2 = new Insect(31);
        System.out.println(insect2.getWeight());
        System.out.println(insect2.getX());
        System.out.println(insect2.getX());
        System.out.println(Insect.getPopulation());
    }
}
