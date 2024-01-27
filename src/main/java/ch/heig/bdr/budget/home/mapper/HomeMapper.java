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
}
