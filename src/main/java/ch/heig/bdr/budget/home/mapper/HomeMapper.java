package ch.heig.bdr.budget.home.mapper;

import ch.heig.bdr.budget.home.domain.Home;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    @Select("SELECT \n" +
            "  mois.numero,\n" +
            "  mois.numeroannee, \n" +
            "  COALESCE(SUM(budget.montant), 0) AS total_depenses\n" +
            "FROM budget\n" +
            "INNER JOIN mois ON budget.anneeMois = mois.numeroannee AND budget.numeroMois = mois.numero\n" +
            "RIGHT JOIN depense ON budget.id = depense.idSortie\n" +
            "GROUP BY mois.numero, mois.numeroannee\n" +
            "ORDER BY mois.numeroannee, mois.numero")
    Home getTotalMonthDepense();

    @Select("SELECT \n" +
            "  mois.numero,\n" +
            "  mois.numeroannee, \n" +
            "  COALESCE(SUM(budget.montant), 0) AS total_epargnes\n" +
            "FROM budget\n" +
            "INNER JOIN mois ON budget.anneeMois = mois.numeroannee AND budget.numeroMois = mois.numero\n" +
            "RIGHT JOIN epargne ON budget.id = epargne.idSortie\n" +
            "GROUP BY mois.numero, mois.numeroannee\n" +
            "ORDER BY mois.numeroannee, mois.numero")
    Home getTotalMonthEpargne();

    @Select("SELECT \n" +
            "  mois.numero,\n" +
            "  mois.numeroannee, \n" +
            "  COALESCE(SUM(budget.montant), 0) AS total_recettes\n" +
            "FROM budget\n" +
            "INNER JOIN mois ON budget.anneeMois = mois.numeroannee AND budget.numeroMois = mois.numero\n" +
            "RIGHT JOIN recette ON budget.id = recette.idEntree\n" +
            "GROUP BY mois.numero, mois.numeroannee\n" +
            "ORDER BY mois.numeroannee, mois.numero")
    Home getTotalMonthRecette();

    @Select("SELECT \n" +
            "  mois.numero,\n" +
            "  mois.numeroannee, \n" +
            "  COALESCE(SUM(budget.montant), 0) AS total_revenus\n" +
            "FROM budget\n" +
            "INNER JOIN mois ON budget.anneeMois = mois.numeroannee AND budget.numeroMois = mois.numero\n" +
            "RIGHT JOIN revenue ON budget.id = revenue.idEntree\n" +
            "GROUP BY mois.numero, mois.numeroannee\n" +
            "ORDER BY mois.numeroannee, mois.numero")
    Home getTotalMonthRevenu();

}
