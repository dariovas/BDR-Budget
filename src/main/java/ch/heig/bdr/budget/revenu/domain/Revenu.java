package ch.heig.bdr.budget.revenu.domain;

public class Revenu {
    private Long id;
    private int anneemois;
    private int numeromois;
    private Long idCategorie;
    private double montant_budget;

    private String origine;

    private boolean hasRecurence = false;
    private Integer recurrenceAnneeMois;
    private Integer recurrenceNumeroMois;
    private Integer recurrenceTousLesNMois;

    public Long getId() {
        return id;
    }

    public void setId(Long id){this.id = id;}

    public int getAnneemois() {
        return anneemois;
    }

    public void setAnneemois(int anneemois) {
        this.anneemois = anneemois;
    }

    public int getNumeromois() {
        return numeromois;
    }

    public void setNumeromois(int numeromois) {
        this.numeromois = numeromois;
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public double getMontant_budget() {
        return montant_budget;
    }

    public void setMontant_budget(double montant_budget) {
        this.montant_budget = montant_budget;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public void setHasRecurence(boolean recurence){this.hasRecurence = recurence;}

    public boolean getHasRecurrence(){return this.hasRecurence;}

    public Integer getRecurrenceAnneeMois(){
        return this.recurrenceAnneeMois;
    }

    public void setRecurrenceAnneeMois(String recurrenceAnneeMois){
        this.recurrenceAnneeMois = Integer.parseInt(recurrenceAnneeMois);
    }

    public void setRecurrenceAnneeMois(int recurrenceAnneeMois){
        this.recurrenceAnneeMois = recurrenceAnneeMois;
    }

    public Integer getRecurrenceNumeroMois(){
        return this.recurrenceNumeroMois;
    }

    public void setRecurrenceNumeroMois(int recurrenceNumeroMois){
        this.recurrenceNumeroMois = recurrenceNumeroMois;
    }

    public void setRecurrenceNumeroMois(String recurrenceNumeroMois){
        this.recurrenceNumeroMois = Integer.parseInt(recurrenceNumeroMois);
    }

    public Integer getRecurrenceTousLesNMois() {
        return recurrenceTousLesNMois;
    }

    public void setRecurrenceTousLesNMois(int recurrenceTousLesNMois) {
        this.recurrenceTousLesNMois = recurrenceTousLesNMois;
    }

    public void setRecurrenceTousLesNMois(String recurrenceTousLesNMois) {
        this.recurrenceTousLesNMois = Integer.parseInt(recurrenceTousLesNMois);
    }
}
