package ch.heig.bdr.budget.home.repository.impl;

import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.home.mapper.HomeMapper;
import ch.heig.bdr.budget.home.domain.Home;
import ch.heig.bdr.budget.home.mapper.HomeMapper;
import ch.heig.bdr.budget.home.repository.HomeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HomeRepositoryImpl implements HomeRepository {

    private HomeMapper mapper;

    /***
     * Constructeur
     * @param mapper : mapper de la classe
     */
    public HomeRepositoryImpl(HomeMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Retourne toutes les dépenses
     * @return : toutes les dépenses
     */
    @Override
    public Home getAllHomes() {
        return mapper.getTotalCurrentMonth();
    }

    /***
     * Retourne le total d'un mois
     * @return
     */
    @Override
    public List<Home> getTotalByMonth() {
        return mapper.getTotalByMonth();
    }

    /***
     * Retourne la moyenne des 12 derniers mois
     * @return : moyenne des 12 derniers mois
     */
    @Override
    public Home getAvgLast12Month() {
        return mapper.getAvgLast12Month();
    }
}
