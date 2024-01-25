package ch.heig.bdr.budget.epargne.repository.impl;

import ch.heig.bdr.budget.epargne.mapper.EpargneMapper;
import ch.heig.bdr.budget.epargne.repository.EpargneRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EpargneRepositoryImpl implements EpargneRepository {
    private EpargneMapper mapper;

    public EpargneRepositoryImpl(EpargneMapper mapper) {
        this.mapper = mapper;
    }
}
