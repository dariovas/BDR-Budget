package ch.heig.bdr.budget.epargne.domain;

public class Epargne {
    private Long id;
    private int anneemois;
    private int numeromois;
    private Long idCategorie;
    private double montant_budget;
    private Long idobjep;
    private String nom_categorie;

    private double montantobjectif;

    private boolean hasRecurence = false;
    private Integer recurrenceAnneeMois;
    private Integer recurrenceNumeroMois;
    private Integer recurrenceTousLesNMois;

    public Long getId() {
        return id;
    }
    public void setId(Long id){this.id = this.id;}

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

    public Long getIdobjep() {
        return idobjep;
    }

    public void setIdobjep(Long idobjep) {
        this.idobjep = idobjep;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public double getMontantobjectif() {
        return montantobjectif;
    }

    public void setMontantobjectif(double montantobjectif) {
        this.montantobjectif = montantobjectif;
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
