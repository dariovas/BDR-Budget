package ch.heig.bdr.budget.recette.mapper;

import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.recette.domain.Recette;
import ch.heig.bdr.budget.revenu.domain.Revenu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecetteMapper {
    @Select("SELECT * FROM vue_recette WHERE id = #{id}")
    Recette select(Long id);

    @Select("SELECT * FROM vue_recette")
    List<Recette> selectAll();

    @Insert("WITH InsertionBudget AS (\n" +
            "    INSERT INTO budget(anneeMois, numeroMois, idCategorie, montant)\n" +
            "    VALUES (#{anneemois}, #{numeromois}, #{idCategorie}, #{montant_budget}) \n" +
            "    RETURNING id\n" +
            "),\n" +
            "InsertionEntree AS (\n" +
            "    INSERT INTO entree(idBudget, origine)\n" +
            "    SELECT id, #{origine} FROM InsertionBudget \n" +
            "    RETURNING idBudget\n" +
            ")\n" +
            "INSERT INTO recette(identree)\n" +
            "SELECT idBudget\n" +
            "FROM InsertionEntree;")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Recette revenu);

}
