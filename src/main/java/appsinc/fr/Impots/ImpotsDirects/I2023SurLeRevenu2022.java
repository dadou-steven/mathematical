package appsinc.fr.Impots.ImpotsDirects;

import java.util.ArrayList;
import java.util.List;

public class I2023SurLeRevenu2022 {

    // déclaration de variables d'instance

    private List<String> redevables;
    private List<Integer> tranchesDeRevenus;
    private List<Integer> tauxDImposition;
    private List<Integer> salairesNets;
    private List<Integer> enfants;

    // constructeur

    public I2023SurLeRevenu2022(List<String> redevables, List<Integer> tranchesDeRevenus,
                                List<Integer> tauxDImposition, List<Integer> salairesNets,
                                List<Integer> enfants) {
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

    public List<Integer> getEnfants() {
        return enfants;
    }

    public void setEnfants(List<Integer> enfants) {
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
     * @param parents les deux partenaires
     * @param pourcent en pourcentage
     * @param parts de l'ensemble de famille
     * @return le résultat brut de leur impôt
     */
    public double marriedChild(double parents, double pourcent, double parts) {
        double step1 = ((getSalairesNets().get(0) + getSalairesNets().get(1)) / parts);
        double step2 = (step1 - getTranchesDeRevenus().get(1)) * (((getTauxDImposition().get(1)) / pourcent));
        return step2 * parts;
    }

    public String toString() {
        return "Impôt brut pour un " + getRedevables().get(0) + " gagnant " + getSalairesNets().get(0) + " € net annuel est de " + seul(100) + " €.\n"
                + "Impôt brut pour un " + getRedevables().get(1) + " gagnant " + (getSalairesNets().get(0) + getSalairesNets().get(1)) + " € net annuel est de " + married(2, 100) + " €.\n"
                + "Impôt brut pour un " + getRedevables().get(2) + " gagnant " + (getSalairesNets().get(0) + getSalairesNets().get(1)) + " € net annuel est de " + marriedChild(2, 100, 2) + " €.\n";
    }

    public void result(String solution) {
        System.out.println(solution);
    }

    // afficher le résultat

    public static void main(String[] args) {

        I2023SurLeRevenu2022 i2023SurLeRevenu2022 = new I2023SurLeRevenu2022
                (new ArrayList<>(List.of("Célibataire sans enfant charge", "Couple marié ou pacsé sans enfant",
                        "Couple marié ou pacsé avec enfants", "Parent isolé sans enfants", "parent isolé avec enfant")),
                        new ArrayList<>(List.of(0, 10777, 27478, 78570, 168994)),
                        new ArrayList<>(List.of(0, 11, 30, 41, 45)),
                        new ArrayList<>(List.of(30000, 30000)),
                        new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        i2023SurLeRevenu2022.result(i2023SurLeRevenu2022.toString());
    }
}
