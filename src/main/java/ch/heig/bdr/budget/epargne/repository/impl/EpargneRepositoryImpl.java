package ch.heig.bdr.budget.epargne.repository.impl;

import ch.heig.bdr.budget.epargne.domain.Epargne;
import ch.heig.bdr.budget.epargne.mapper.EpargneMapper;
import ch.heig.bdr.budget.epargne.repository.EpargneRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EpargneRepositoryImpl implements EpargneRepository {
    private EpargneMapper mapper;

    /***
     * Constructeur
     * @param mapper : mapper de la classe
     */
    public EpargneRepositoryImpl(EpargneMapper mapper) {
        this.mapper = mapper;
    }

    /***
     * Retourne toutes les épargnes
     * @return : toutes les épargnes
     */
    @Override
    public List<Epargne> getAllEpargne() {
        return mapper.selectAll();
    }

    /***
     * Rajoute une épargne
     * @param epargne : épargne à rajouter
     */
    @Override
    public void addEpargne(Epargne epargne) {
        mapper.insert(epargne);
    }
}
