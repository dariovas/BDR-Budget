package ch.heig.bdr.budget.home.repository;

import ch.heig.bdr.budget.home.domain.Home;

import java.util.List;


public interface HomeRepository {
    Home getAllHomes();

    List<Home> getTotalByMonth();

    Home getAvgLast12Month();
}
