package ch.heig.bdr.budget.home.domain;

public class Home {
    private int mois;
    private int annee;

    private double total_epargnes;
    private double total_depenses;
    private double total_recettes;
    private double total_revenus;

    public double getTotal_epargnes() {
        return total_epargnes;
    }

    public void setTotal_epargnes(double total_epargnes) {
        this.total_epargnes = total_epargnes;
    }

    public double getTotal_depenses() {
        return total_depenses;
    }

    public void setTotal_depenses(double total_depenses) {
        this.total_depenses = total_depenses;
    }

    public double getTotal_recettes() {
        return total_recettes;
    }

    public void setTotal_recettes(double total_recettes) {
        this.total_recettes = total_recettes;
    }

    public double getTotal_revenus() {
        return total_revenus;
    }

    public void setTotal_revenus(double total_revenus) {
        this.total_revenus = total_revenus;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public double getTotal(){
        return total_revenus + total_recettes - total_depenses -total_epargnes;
    }
}
