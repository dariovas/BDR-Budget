package ch.heig.bdr.budget.depense.domain;

public class Depense {
    private Long id;
    private int anneemois;
    private int numeromois;
    private Long idCategorie;
    private double montant_budget;
    private String beneficiaire;

    private boolean hasRecurrence = false;
    private Integer recurrenceAnneeMois;
    private Integer recurrenceNumeroMois;
    private Integer recurrenceTousLesNMois;

    public Long getId() {
        return id;
    }

    public Long getId_budget() {
        return id;
    }

    public void setId_budget(Long id_budget) {
        this.id = id_budget;
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

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public void setHasRecurrence(boolean recurence){this.hasRecurrence = recurence;}

    public boolean getHasRecurrence(){return this.hasRecurrence;}

    public Integer getRecurrenceAnneeMois(){
        return this.recurrenceAnneeMois;
    }

    public void setRecurrenceAnneeMois(Integer recurrenceAnneeMois){
        this.recurrenceAnneeMois = recurrenceAnneeMois;
    }

    public Integer getRecurrenceNumeroMois(){
        return this.recurrenceNumeroMois;
    }

    public void setRecurrenceNumeroMois(Integer recurrenceNumeroMois){
        this.recurrenceNumeroMois = recurrenceNumeroMois;
    }

    public Integer getRecurrenceTousLesNMois() {
        return recurrenceTousLesNMois;
    }

    public void setRecurrenceTousLesNMois(Integer recurrenceTousLesNMois) {
        this.recurrenceTousLesNMois = recurrenceTousLesNMois;
    }
}
