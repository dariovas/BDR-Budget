package ch.heig.bdr.budget.bdgt.domain;

public class Budget {
    private Long id;
    private double montant;

    public Budget(Long id, double montant) {
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
