package ch.heig.bdr.budget.depense.repository;

import ch.heig.bdr.budget.depense.domain.Depense;

import java.util.List;

public interface DepenseRepository {
    List<Depense> getAllDepenses();

    List<Depense> getDepensesFromBenificiaire(String name);

    void addDepense(Depense depense);

}
