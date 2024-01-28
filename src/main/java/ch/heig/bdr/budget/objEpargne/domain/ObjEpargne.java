package ch.heig.bdr.budget.objEpargne.domain;

public class ObjEpargne {
    private Long id;
    private double montant;

    private int anneemois;
    private int numeromois;

    private double montantepargne;
    private int moisrestant;
    private int idCategorie;

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getAnneemois() {
        return anneemois;
    }

    public double getMontantepargne() {
        return montantepargne;
    }

    public void setMontantepargne(double montantepargne) {
        this.montantepargne = montantepargne;
    }

    public int getMoisrestant() {
        return moisrestant;
    }

    public void setMoisrestant(int moisrestant) {
        this.moisrestant = moisrestant;
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
}
