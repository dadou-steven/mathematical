package appsinc.fr.Impots.ImpotsDirects;

import java.util.ArrayList;
import java.util.List;

public class I2023SurLeRevenu2022 {

    // déclaration de variables d'instance

    private List<String> redevables;
    private List<Integer> tranchesDeRevenus;
    private List<Integer> tauxDImposition;
    private List<Integer> salairesNets;
    private List<Double> enfants;

    // constructeur

    public I2023SurLeRevenu2022(List<String> redevables, List<Integer> tranchesDeRevenus,
                                List<Integer> tauxDImposition, List<Integer> salairesNets,
                                List<Double> enfants) {
        this.redevables = redevables;
        this.tranchesDeRevenus = tranchesDeRevenus;
        this.tauxDImposition = tauxDImposition;
        this.salairesNets = salairesNets;
        this.enfants = enfants;
    }

    // méthodes accesseurs (getters) et mutateurs (setters)

    public List<String> getRedevables() {
        return redevables;
    }

    public void setRedevables(List<String> redevables) {
        this.redevables = redevables;
    }

    public List<Integer> getTranchesDeRevenus() {
        return tranchesDeRevenus;
    }

    public void setTranchesDeRevenus(List<Integer> tranchesDeRevenus) {
        this.tranchesDeRevenus = tranchesDeRevenus;
    }

    public List<Integer> getTauxDImposition() {
        return tauxDImposition;
    }

    public void setTauxDImposition(List<Integer> tauxDImposition) {
        this.tauxDImposition = tauxDImposition;
    }

    public List<Integer> getSalairesNets() {
        return salairesNets;
    }

    public void setSalairesNets(List<Integer> salairesNets) {
        this.salairesNets = salairesNets;
    }

    public List<Double> getEnfants() {
        return enfants;
    }

    public void setEnfants(List<Double> enfants) {
        this.enfants = enfants;
    }

    // méthodes

    /**
     * Célibataire sans enfants
     * @param pourcent en pourcentage
     * @return le résultat brut d'imposition
     */
    public double seul(double pourcent) {
        double step1 = ((getTranchesDeRevenus().get(2) - (getTranchesDeRevenus().get(1))) * (getTauxDImposition().get(1) / pourcent));
        double step2 = ((getSalairesNets().get(0) - getTranchesDeRevenus().get(2))) * (getTauxDImposition().get(2) / pourcent);
        return getTranchesDeRevenus().get(0) + step1 + step2;
    }

    /**
     * Marié ou pacsé sans enfants
     * @param personnes les deux partenaires
     * @param pourcent en pourcentage
     * @return le résultat brut de leur impôt
     */
    public double married(double personnes, double pourcent) {
        double step1 = (getSalairesNets().get(0) + getSalairesNets().get(1)) / personnes;
        double step2 = ((getTranchesDeRevenus().get(2) - (getTranchesDeRevenus().get(1))) * (getTauxDImposition().get(1) / pourcent));
        double step3 = ((step1 - getTranchesDeRevenus().get(2))) * (getTauxDImposition().get(2) / pourcent);
        double step4 = getTranchesDeRevenus().get(0) + step2 + step3;
        return step4 * 2;
    }

    /**
     * Marié ou pacsé avec enfants
     * @param pourcent en pourcentage
     * @return le résultat brut de leur impôt
     */
    public double marriedChild(double pourcent) {
        double step1 = ((getSalairesNets().get(0) + getSalairesNets().get(1)) / getEnfants().get(5));
        double step2 = (step1 - getTranchesDeRevenus().get(1)) * (((getTauxDImposition().get(1)) / pourcent));
        return step2 * getEnfants().get(5);
    }

    public String toString() {
        return "Impôt brut pour un " + getRedevables().get(0) + " gagnant " + getSalairesNets().get(0) + " € net annuel est de " + seul(100) + " €.\n"
                + "Impôt brut pour un " + getRedevables().get(1) + " gagnant " + (getSalairesNets().get(0) + getSalairesNets().get(1)) + " € net annuel est de " + married(2, 100) + " €.\n"
                + "Impôt brut pour un " + getRedevables().get(2) + " gagnant " + (getSalairesNets().get(0) + getSalairesNets().get(1)) + " € net annuel est de " + marriedChild(100) + " €.\n";
    }

    public void result(String solution) {
        System.out.println(solution);
    }

    // afficher le résultat

    public static void main(String[] args) {

        I2023SurLeRevenu2022 i2023SurLeRevenu2022 = new I2023SurLeRevenu2022
                (new ArrayList<>(List.of("Célibataire sans enfant charge", "Couple marié ou pacsé sans enfant",
                        "Couple marié ou pacsé avec enfants", "parent isolé")),
                        new ArrayList<>(List.of(0, 10777, 27478, 78570, 168994)),
                        new ArrayList<>(List.of(0, 11, 30, 41, 45)),
                        new ArrayList<>(List.of(30000, 30000)),
                        new ArrayList<>(List.of(0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5)));

        i2023SurLeRevenu2022.result(i2023SurLeRevenu2022.toString());
    }
}
