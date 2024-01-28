package ch.heig.bdr.budget.objEpargne.repository.impl;

import ch.heig.bdr.budget.epargne.domain.Epargne;
import ch.heig.bdr.budget.objEpargne.domain.ObjEpargne;
import ch.heig.bdr.budget.objEpargne.mapper.ObjEpargneMapper;
import ch.heig.bdr.budget.objEpargne.repository.ObjEpargneRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ObjEpargneRepositoryImpl implements ObjEpargneRepository {
    private ObjEpargneMapper mapper;

    public ObjEpargneRepositoryImpl(ObjEpargneMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ObjEpargne> getAllObjEpargnes(){
        return mapper.selectAll();
    }

    @Override
    public void addObjEpargne(ObjEpargne objEpargne){
        mapper.insert(objEpargne);
    }
}
