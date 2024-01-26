package ch.heig.bdr.budget.categorie.domain;

public class Categorie {
    private Long id;
    private String nom;
    private String description;
    private Long idParent;

    private String nom_categorie_parente;

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdParent() {
        return idParent;
    }

    public void setIdParent(Long idParent) {
        this.idParent = idParent;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom_categorie_parente() {
        return nom_categorie_parente;
    }

    public void setNom_categorie_parente(String nom_categorie_parente) {
        this.nom_categorie_parente = nom_categorie_parente;
    }
}
