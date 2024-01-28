package ch.heig.bdr.budget.recurrence.mapper;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.recurrence.domain.Recurrence;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface RecurrenceMapper {

    /***
     * Sélectionne toutes les récurrences
     * @return : récurrences sélectionnées
     */
    @Select("SELECT * FROM recurrence")
    List<Recurrence> selectAll();

    /**
     * Insére une nouvelle récurrence
     * @param recurrence : récurrence à insérer
     * @return : nombre de lignes insérées
     */
    @Insert("INSERT INTO recurrence(idbudget, anneemois, numeromois, touslesnmois)\n" +
            "VALUES  (#{idbudget}, #{anneemois}, #{numeromois}, #{touslesnmois})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Recurrence recurrence);

    /**
     * Insére une nouvelle récurrence sans fin
     * @param recurrence : récurrence à insérer
     * @return : nombre de lignes insérées
     */
    @Insert("INSERT INTO recurrence(idbudget, anneemois, numeromois, touslesnmois)\n" +
            "VALUES  (#{idbudget}, NULL, NULL, #{touslesnmois})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertWithoutEnd(Recurrence recurrence);
}

