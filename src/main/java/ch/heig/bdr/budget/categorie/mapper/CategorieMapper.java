package ch.heig.bdr.budget.categorie.mapper;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategorieMapper {
    /***
     * Sélectionne une catégorie par son id
     * @param id : id de la catégorie à sélectionner
     * @return : catégorie sélectionnée
     */
    @Select("SELECT * FROM Categorie WHERE id = #{id}")
    Categorie select(Long id);

    /***
     * Sélectionne toutes les catégories
     * @return : liste des catégories
     */
    @Select("SELECT categorie.id, categorie.nom, categorie.description, parent.nom AS nom_categorie_parente\n" +
        "FROM categorie\n" +
        "    LEFT JOIN categorie parent ON categorie.idParent = parent.id;")
    List<Categorie> selectAll();


    /***
     * Insert une nouvelle catégorie
     * @param categorie : catégorie à insérer
     * @return : nombre de lignes insérées
     */
    @Insert("INSERT INTO Categorie (nom, description, idparent) VALUES (#{nom}, #{description}, #{idparent})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Categorie categorie);
}
