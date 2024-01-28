package ch.heig.bdr.budget.home.mapper;

import ch.heig.bdr.budget.home.domain.Home;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomeMapper {
    @Select("SELECT\n" +
            "    (SELECT SUM(b.montant) FROM budget b JOIN epargne e ON b.id = e.idSortie\n" +
            "     WHERE b.anneeMois = EXTRACT(YEAR FROM CURRENT_DATE) AND b.numeroMois = EXTRACT(MONTH FROM CURRENT_DATE)) AS total_epargnes,\n" +
            "\n" +
            "    (SELECT SUM(b.montant) FROM budget b JOIN sortie s ON b.id = s.idBudget\n" +
            "     JOIN depense d ON s.idBudget = d.idSortie\n" +
            "     WHERE b.anneeMois = EXTRACT(YEAR FROM CURRENT_DATE) AND b.numeroMois = EXTRACT(MONTH FROM CURRENT_DATE)) AS total_depenses,\n" +
            "\n" +
            "    (SELECT SUM(b.montant) FROM budget b JOIN entree e ON b.id = e.idBudget\n" +
            "     JOIN recette r ON e.idBudget = r.idEntree\n" +
            "     WHERE b.anneeMois = EXTRACT(YEAR FROM CURRENT_DATE) AND b.numeroMois = EXTRACT(MONTH FROM CURRENT_DATE)) AS total_recettes,\n" +
            "\n" +
            "    (SELECT SUM(b.montant) FROM budget b JOIN entree e ON b.id = e.idBudget\n" +
            "     JOIN revenue rv ON e.idBudget = rv.idEntree\n" +
            "     WHERE b.anneeMois = EXTRACT(YEAR FROM CURRENT_DATE) AND b.numeroMois = EXTRACT(MONTH FROM CURRENT_DATE)) AS total_revenus")
    Home getTotalCurrentMonth();

    @Select("SELECT\n" +
            "        mois.nom as mois,\n" +
            "        mois.numeroannee as annee,\n" +
            "        COALESCE(SUM(CASE WHEN depense.idSortie IS NOT NULL THEN budget.montant ELSE 0 END), 0) AS total_depenses, \n" +
            "        COALESCE(SUM(CASE WHEN epargne.idSortie IS NOT NULL THEN budget.montant ELSE 0 END), 0) AS total_epargnes, \n" +
            "        COALESCE(SUM(CASE WHEN recette.idEntree IS NOT NULL THEN budget.montant ELSE 0 END), 0) AS total_recettes, \n" +
            "        COALESCE(SUM(CASE WHEN revenue.idEntree IS NOT NULL THEN budget.montant ELSE 0 END), 0) AS total_revenus\n" +
            "        FROM budget\n" +
            "        INNER JOIN mois ON budget.anneeMois = mois.numeroannee AND budget.numeroMois = mois.numero\n" +
            "        LEFT JOIN depense ON budget.id = depense.idSortie\n" +
            "        LEFT JOIN epargne ON budget.id = epargne.idSortie\n" +
            "        LEFT JOIN recette ON budget.id = recette.idEntree \n" +
            "        LEFT JOIN revenue ON budget.id = revenue.idEntree\n" +
            "        GROUP BY mois.numero, mois.numeroannee\n" +
            "        ORDER BY mois.numeroannee, mois.numero")
    List<Home> getTotalByMonth();

    @Select("SELECT\n" +
            "    COALESCE(AVG(CASE WHEN depense.idSortie IS NOT NULL THEN budget.montant END), 0) AS avg_depenses, \n" +
            "    COALESCE(AVG(CASE WHEN epargne.idSortie IS NOT NULL THEN budget.montant END), 0) AS avg_epargnes, \n" +
            "    COALESCE(AVG(CASE WHEN recette.idEntree IS NOT NULL THEN budget.montant END), 0) AS avg_recettes, \n" +
            "    COALESCE(AVG(CASE WHEN revenue.idEntree IS NOT NULL THEN budget.montant END), 0) AS avg_revenus\n" +
            "FROM\n" +
            "    budget\n" +
            "    INNER JOIN mois ON budget.anneeMois = mois.numeroannee AND budget.numeroMois = mois.numero\n" +
            "    LEFT JOIN depense ON budget.id = depense.idSortie\n" +
            "    LEFT JOIN epargne ON budget.id = epargne.idSortie\n" +
            "    LEFT JOIN recette ON budget.id = recette.idEntree \n" +
            "    LEFT JOIN revenue ON budget.id = revenue.idEntree\n" +
            "WHERE \n" +
            "    (mois.numero < EXTRACT(MONTH FROM CURRENT_DATE) AND mois.numeroannee = EXTRACT(YEAR FROM CURRENT_DATE)) OR\n" +
            "    (mois.numero >= EXTRACT(MONTH FROM CURRENT_DATE) AND mois.numeroannee < EXTRACT(YEAR FROM CURRENT_DATE))\n" +
            "LIMIT 12")
    Home getAvgLast12Month();
}
