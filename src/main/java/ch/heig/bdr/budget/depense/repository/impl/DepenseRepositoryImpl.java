package ch.heig.bdr.budget.depense.repository.impl;

import ch.heig.bdr.budget.depense.mapper.DepenseMapper;
import ch.heig.bdr.budget.depense.repository.DepenseRepository;
import org.springframework.stereotype.Repository;
@Repository
public class DepenseRepositoryImpl implements DepenseRepository {

    private DepenseMapper mapper;

}
