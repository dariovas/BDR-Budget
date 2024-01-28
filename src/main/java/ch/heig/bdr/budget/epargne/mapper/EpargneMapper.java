package ch.heig.bdr.budget.epargne.mapper;

import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.epargne.domain.Epargne;
import ch.heig.bdr.budget.epargne.domain.EpargneController;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EpargneMapper {
    /***
     * Sélectionne une épargne par son id
     * @param id : id de l'épargne à sélectionner
     * @return : épargne sélectionnée
     */
    @Select("SELECT * FROM vue_epargne WHERE id = #{id}")
    Epargne select(Long id);

    /***
     * Sélectionne toutes les épargnes
     * @return : liste des épargnes
     */
    @Select("SELECT * FROM vue_epargne")
    List<Epargne> selectAll();


    /***
     * Insére une nouvelle épargne
     * @param epargne : épargne à insérer
     * @return : nombre de lignes insérées
     */
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
            "INSERT INTO epargne(idSortie, idObjEp)\n" +
            "SELECT idBudget, #{idobjep}\n" +
            "FROM InsertionSortie;")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Epargne epargne);

}
