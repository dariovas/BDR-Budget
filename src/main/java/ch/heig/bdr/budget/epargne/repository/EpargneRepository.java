package ch.heig.bdr.budget.epargne.repository;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.epargne.domain.Epargne;

import java.util.List;

public interface EpargneRepository {
    List<Epargne> getAllEpargne();

    void addEpargne(Epargne epargne);
}
