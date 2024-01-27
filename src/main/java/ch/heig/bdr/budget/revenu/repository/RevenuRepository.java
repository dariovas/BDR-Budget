package ch.heig.bdr.budget.revenu.repository;

import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.revenu.domain.Revenu;

import java.util.List;

public interface RevenuRepository {
    List<Revenu> getAllRevenus();
    void addRevenus(Revenu revenu);
}
