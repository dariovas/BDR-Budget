package ch.heig.bdr.budget.epargne.mapper;

import ch.heig.bdr.budget.epargne.domain.Epargne;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EpargneMapper {
    @Select("SELECT * FROM vue_epargne WHERE id = #{id}")
    Epargne select(Long id);

    @Select("SELECT * FROM vue_epargne\n" +
            "INNER JOIN categorie ON vue_epargne.idCategorie = categorie.id")
    List<Epargne> selectAll();

}
