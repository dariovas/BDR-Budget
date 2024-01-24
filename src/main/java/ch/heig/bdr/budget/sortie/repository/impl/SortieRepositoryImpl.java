package ch.heig.bdr.budget.sortie.repository.impl;

import ch.heig.bdr.budget.sortie.mapper.SortieMapper;
import ch.heig.bdr.budget.sortie.repository.SortieRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SortieRepositoryImpl implements SortieRepository {
    private SortieMapper mapper;

}
