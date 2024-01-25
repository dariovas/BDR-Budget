package ch.heig.bdr.budget.epargne.domain;

public class Epargne {
    private Long id_budget;
    private int anneemois;
    private int numeromois;
    private Long idCategorie;
    private double montant_budget;
    private Long idobjep;

    private Long idcategorieobjectif;
    private int anneemoisobjectif;
    private int numeromoisobjectif;
    private  double montantobjectif;

    private String nom;

    public Long getId_budget() {
        return id_budget;
    }

    public void setId_budget(Long id_budget) {
        this.id_budget = id_budget;
    }

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

    public Long getIdcategorieobjectif() {
        return idcategorieobjectif;
    }

    public void setIdcategorieobjectif(Long idcategorieobjectif) {
        this.idcategorieobjectif = idcategorieobjectif;
    }

    public int getAnneemoisobjectif() {
        return anneemoisobjectif;
    }

    public void setAnneemoisobjectif(int anneemoisobjectif) {
        this.anneemoisobjectif = anneemoisobjectif;
    }

    public int getNumeromoisobjectif() {
        return numeromoisobjectif;
    }

    public void setNumeromoisobjectif(int numeromoisobjectif) {
        this.numeromoisobjectif = numeromoisobjectif;
    }

    public double getMontantobjectif() {
        return montantobjectif;
    }

    public void setMontantobjectif(double montantobjectif) {
        this.montantobjectif = montantobjectif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
