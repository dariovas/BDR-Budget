package ch.heig.bdr.budget.recette.mapper;

import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.recette.domain.Recette;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecetteMapper {
    @Select("SELECT * FROM vue_recette WHERE id = #{id}")
    Recette select(Long id);

    @Select("SELECT * FROM vue_recette")
    List<Recette> selectAll();

}
