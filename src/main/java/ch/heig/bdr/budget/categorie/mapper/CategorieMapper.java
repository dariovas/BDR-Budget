package ch.heig.bdr.budget.categorie.mapper;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CategorieMapper {
    @Select("SELECT * FROM Categorie WHERE id = #{id}")
    Categorie select(Long id);
/*
    @Select("SELECT * FROM Categorie")
    List<Categorie> selectAll();/*


 */
    @Select("SELECT categorie.id, categorie.nom, categorie.description, parent.nom AS nom_categorie_parente\n" +
        "FROM categorie\n" +
        "    LEFT JOIN categorie parent ON categorie.idParent = parent.id;")
    List<Categorie> selectAll();

    @Update("UPDATE Categorie SET ")
    Categorie update();
}
