package ch.heig.bdr.budget.depense.domain;

public class Depense {
    private Long id_budget;
    private int anneemois;
    private int numeromois;
    private Long idCategorie;
    private double montant_budget;
    private String beneficiaire;

    private boolean hasRecurence = false;
    private int recurrenceAnneeMois;
    private int recurrenceNumeroMois;
    private int recurrenceTousLesNMois;


    public Long getId_budget() {
        return id_budget;
    }

    public void setId_budget(Long id_budget) {
        this.id_budget = id_budget;
    }
    public void setId(Long id){this.id_budget = id;}
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

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public void setHasRecurence(boolean recurence){this.hasRecurence = recurence;}
    public boolean getHasRecurrence(){return this.hasRecurence;}

    public int getRecurrenceAnneeMois(){
        return this.recurrenceAnneeMois;
    }
    public void setRecurrenceAnneeMois(int recurrenceAnneeMois){
        this.recurrenceAnneeMois = recurrenceAnneeMois;
    }
    public int getRecurrenceNumeroMois(){
        return this.recurrenceNumeroMois;
    }

    public void setRecurrenceNumeroMois(int recurrenceNumeroMois){
        this.recurrenceNumeroMois = recurrenceNumeroMois;
    }

    public int getRecurrenceTousLesNMois() {
        return recurrenceTousLesNMois;
    }

    public void setRecurrenceTousLesNMois(int recurrenceTousLesNMois) {
        this.recurrenceTousLesNMois = recurrenceTousLesNMois;
    }
}
