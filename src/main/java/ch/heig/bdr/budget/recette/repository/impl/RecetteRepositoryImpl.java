package ch.heig.bdr.budget.recette.repository.impl;

import ch.heig.bdr.budget.recette.domain.Recette;
import ch.heig.bdr.budget.recette.mapper.RecetteMapper;
import ch.heig.bdr.budget.recette.repository.RecetteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecetteRepositoryImpl implements RecetteRepository {
    private RecetteMapper mapper;

    public RecetteRepositoryImpl(RecetteMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Recette> getAllRecettes() {
        return mapper.selectAll();
    }
}
