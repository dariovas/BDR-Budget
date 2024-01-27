package ch.heig.bdr.budget.revenu.repository.impl;

import ch.heig.bdr.budget.revenu.domain.Revenu;
import ch.heig.bdr.budget.revenu.mapper.RevenuMapper;
import ch.heig.bdr.budget.revenu.repository.RevenuRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RevenuRepositoryImpl implements RevenuRepository {
    private RevenuMapper mapper;

    public RevenuRepositoryImpl(RevenuMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Revenu> getAllRevenus() {
        return mapper.selectAll();
    }

    @Override
    public void addRevenus(Revenu revenu) {
        mapper.insert(revenu);
    }
}
