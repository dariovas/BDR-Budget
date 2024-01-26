package ch.heig.bdr.budget.revenu.mapper;

import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.revenu.domain.Revenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RevenuMapper {
    @Select("SELECT * FROM vue_revenue WHERE id = #{id}")
    Revenu select(Long id);

    @Select("SELECT * FROM vue_revenue")
    List<Revenu> selectAll();
}
