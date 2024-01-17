package ch.heig.bdr.budget.categorie.mapper;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("SELECT * FROM Categorie WHERE id = #{id}")
    Categorie select(Long id);

    @Select("SELECT * FROM Categorie")
    List<Categorie> selectAll();

    @Update("UPDATE Categorie SET ")
    Categorie update();
}
