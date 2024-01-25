package ch.heig.bdr.budget.objEpargne.repository.impl;

import ch.heig.bdr.budget.objEpargne.mapper.ObjEpargneMapper;
import ch.heig.bdr.budget.objEpargne.repository.ObjEpargneRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ObjEpargneRepositoryImpl implements ObjEpargneRepository {
    private ObjEpargneMapper mapper;

    public ObjEpargneRepositoryImpl(ObjEpargneMapper mapper) {
        this.mapper = mapper;
    }
}
