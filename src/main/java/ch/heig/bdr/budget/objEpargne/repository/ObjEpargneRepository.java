package ch.heig.bdr.budget.objEpargne.repository;

import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.epargne.domain.Epargne;
import ch.heig.bdr.budget.objEpargne.domain.ObjEpargne;
import java.util.List;

public interface ObjEpargneRepository {
    List<ObjEpargne> getAllObjEpargnes();

    void addObjEpargne(ObjEpargne objEpargne);
}
