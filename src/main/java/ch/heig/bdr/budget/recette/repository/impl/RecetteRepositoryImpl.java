package ch.heig.bdr.budget.recette.repository.impl;

import ch.heig.bdr.budget.recette.domain.Recette;
import ch.heig.bdr.budget.recette.mapper.RecetteMapper;
import ch.heig.bdr.budget.recette.repository.RecetteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecetteRepositoryImpl implements RecetteRepository {
    private RecetteMapper mapper;

    /***
     * Constructeur
     * @param mapper : mapper de la classe
     */
    public RecetteRepositoryImpl(RecetteMapper mapper) {
        this.mapper = mapper;
    }

    /***
     * Retourne toutes les recettes
     * @return : toutes les recettes
     */
    @Override
    public List<Recette> getAllRecettes() {
        return mapper.selectAll();
    }

    /***
     * Rajoute une recette
     * @param recette : recette à rajouter
     */
    @Override
    public void addRecette(Recette recette) {
        mapper.insert(recette);
    }
}
