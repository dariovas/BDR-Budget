package ch.heig.bdr.budget.depense.mapper;

import ch.heig.bdr.budget.depense.domain.Depense;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface DepenseMapper {

    @Select("SELECT * FROM vue_depense WHERE id = #{id}")
    Depense select(Long id);

    @Select("SELECT * FROM vue_depense")
    List<Depense> selectAll();
}
