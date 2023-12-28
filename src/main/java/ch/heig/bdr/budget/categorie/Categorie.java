package ch.heig.bdr.budget.categorie;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLSelect;

import java.util.*;

@Entity
@Table(name = "Categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;

    @ManyToOne
    @JoinColumn(name = "idParent")
    private Categorie parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Categorie> enfants = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Categorie getParent() {
        return parent;
    }

    public boolean hasEnfants(){
        return enfants != null;
    }
    public List<Categorie> getEnfants() {
        return enfants;
    }
}
