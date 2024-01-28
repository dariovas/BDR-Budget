package ch.heig.bdr.budget.home.repository.impl;

import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.home.mapper.HomeMapper;
import ch.heig.bdr.budget.home.domain.Home;
import ch.heig.bdr.budget.home.mapper.HomeMapper;
import ch.heig.bdr.budget.home.repository.HomeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HomeRepositoryImpl implements HomeRepository {

    private HomeMapper mapper;

    public HomeRepositoryImpl(HomeMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    public Home getAllHomes() {
        return mapper.getTotalCurrentMonth();
    }

    @Override
    public Home getTotalDepenseByMonth() {
        return mapper.getTotalMonthDepense();
    }

    @Override
    public Home getTotalRecetteByMonth() {
        return mapper.getTotalMonthRecette();
    }

    @Override
    public Home getTotalRevenuByMonth() {
        return mapper.getTotalMonthRevenu();
    }

    @Override
    public Home getTotalEpargneByMonth() {
        return mapper.getTotalMonthEpargne();
    }

}
