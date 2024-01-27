package ch.heig.bdr.budget.revenu.mapper;

import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.revenu.domain.Revenu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RevenuMapper {
    @Select("SELECT * FROM vue_revenue WHERE id = #{id}")
    Revenu select(Long id);

    @Select("SELECT * FROM vue_revenue")
    List<Revenu> selectAll();

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
            "INSERT INTO revenue(identree)\n" +
            "SELECT idBudget\n" +
            "FROM InsertionEntree;")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Revenu revenu);
}
