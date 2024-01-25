package ch.heig.bdr.budget.recurrence.domain;

public class Recurrence {
    private Long id;
    private Long idbudget;

    private int anneemois;

    private int numeromois;

    private int touslesnmois;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdbudget() {
        return idbudget;
    }

    public void setIdbudget(Long idbudget) {
        this.idbudget = idbudget;
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

    public int getTouslesnmois() {
        return touslesnmois;
    }

    public void setTouslesnmois(int touslesnmois) {
        this.touslesnmois = touslesnmois;
    }
}
