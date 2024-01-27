package ch.heig.bdr.budget.recette.repository;

import ch.heig.bdr.budget.recette.domain.Recette;

import java.util.List;

public interface RecetteRepository {
    List<Recette> getAllRecettes();

    void addRecette(Recette recette);
}
