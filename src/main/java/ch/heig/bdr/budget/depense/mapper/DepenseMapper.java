package ch.heig.bdr.budget.depense.mapper;

import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.categorie.domain.Categorie;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface DepenseMapper {

    @Select("SELECT * FROM vue_depense WHERE id = #{id}")
    Depense select(Long id);

    @Select("SELECT * FROM vue_depense")
    List<Depense> selectAll();

    @Select("SELECT * FROM vue_depense WHERE beneficiaire LIKE #{name}")
    List<Depense> selectByBeneficiaire(@Param("name") String name);
    @Insert("WITH InsertionBudget AS (\n" +
            "    INSERT INTO budget(anneeMois, numeroMois, idCategorie, montant)\n" +
            "    VALUES (#{anneemois}, #{numeromois}, #{idCategorie}, #{montant_budget}) \n" +
            "    RETURNING id\n" +
            "),\n" +
            "InsertionSortie AS (\n" +
            "    INSERT INTO sortie(idBudget)\n" +
            "    SELECT id FROM InsertionBudget \n" +
            "    RETURNING idBudget\n" +
            ")\n" +
            "INSERT INTO depense(idSortie, beneficiaire)\n" +
            "SELECT idBudget, #{beneficiaire}\n" +
            "FROM InsertionSortie;")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Depense depense);
}
