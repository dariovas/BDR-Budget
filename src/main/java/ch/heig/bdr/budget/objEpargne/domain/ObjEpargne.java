package ch.heig.bdr.budget.objEpargne.domain;

public class ObjEpargne {
    private Long id;
    private double montant = 0;

    public ObjEpargne(Long id, double montant) {
        this.id = id;
        this.montant = montant;
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
}
