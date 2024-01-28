package ch.heig.bdr.budget.home.domain;

public class Home {
    private String mois;
    private int annee;

    private double avg_epargnes;
    private double avg_depenses;
    private double avg_recettes;
    private double avg_revenus;

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

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
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


    public double getAvg_epargnes() {
        return avg_epargnes;
    }

    public void setAvg_epargnes(double avg_epargnes) {
        this.avg_epargnes = avg_epargnes;
    }

    public double getAvg_depenses() {
        return avg_depenses;
    }

    public void setAvg_depenses(double avg_depenses) {
        this.avg_depenses = avg_depenses;
    }

    public double getAvg_recettes() {
        return avg_recettes;
    }

    public void setAvg_recettes(double avg_recettes) {
        this.avg_recettes = avg_recettes;
    }

    public double getAvg_revenus() {
        return avg_revenus;
    }

    public void setAvg_revenus(double avg_revenus) {
        this.avg_revenus = avg_revenus;
    }
}
