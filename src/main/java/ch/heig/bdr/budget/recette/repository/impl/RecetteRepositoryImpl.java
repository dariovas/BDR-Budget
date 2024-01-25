package ch.heig.bdr.budget.recette.repository.impl;

import ch.heig.bdr.budget.recette.mapper.RecetteMapper;
import ch.heig.bdr.budget.recette.repository.RecetteRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RecetteRepositoryImpl implements RecetteRepository {
    private RecetteMapper mapper;

}
