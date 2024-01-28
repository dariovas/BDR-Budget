package ch.heig.bdr.budget.depense.repository.impl;

import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.depense.mapper.DepenseMapper;
import ch.heig.bdr.budget.depense.repository.DepenseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepenseRepositoryImpl implements DepenseRepository {

    private DepenseMapper mapper;

    /***
     * Constructeur
     * @param mapper : mapper de la classe
     */
    public DepenseRepositoryImpl(DepenseMapper mapper) {
        this.mapper = mapper;
    }

    /***
     * Retourne toutes les dépenses
     * @return : toutes les dépenses
     */
    @Override
    public List<Depense> getAllDepenses() {
        return mapper.selectAll();
    }

    /***
     * Recherche une dépense par le bénéficiaire
     * @param name : nom du bénéficiaire
     * @return : liste des dépenses du bénéficiaire
     */
    @Override
    public List<Depense> searchDepenseByBeneficiaire(String name) {
        return mapper.selectByBeneficiaire(name);
    }

    /***
     * Ajoute une nouvelle dépense
     * @param depense : dépense à ajouter
     */
    @Override
    public void addDepense(Depense depense) {
        mapper.insert(depense);
    }
}
