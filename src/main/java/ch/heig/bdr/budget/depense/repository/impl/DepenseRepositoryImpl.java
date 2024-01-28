package ch.heig.bdr.budget.depense.repository.impl;

import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.depense.mapper.DepenseMapper;
import ch.heig.bdr.budget.depense.repository.DepenseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepenseRepositoryImpl implements DepenseRepository {

    private DepenseMapper mapper;

    public DepenseRepositoryImpl(DepenseMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Depense> getAllDepenses() {
        return mapper.selectAll();
    }

    @Override
    public List<Depense> getDepensesFromBenificiaire(String name) {
        return mapper.selectByBeneficiaire(name);
    }

    @Override
    public void addDepense(Depense depense) {
        mapper.insert(depense);
    }
}
