package ch.heig.bdr.budget.objEpargne.mapper;

import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.objEpargne.domain.ObjEpargne;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ObjEpargneMapper {

    /***
     * Sélectionne tous les objectifs d'épargne
     * @return : objectifs d'épargne sélectionnés
     */
    @Select("SELECT \n" +
            "    oe.id,\n" +
            "    oe.idCategorie,\n" +
            "    c.nom AS nomCategorie,\n" +
            "    oe.anneeMois,\n" +
            "    oe.numeroMois,\n" +
            "    oe.montant,\n" +
            "    COALESCE(SUM(b.montant), 0) AS montantEpargne,\n" +
            "    CASE \n" +
            "        WHEN COALESCE(SUM(b.montant), 0) = 0 THEN NULL\n" +
            "        ELSE CEIL((oe.montant - COALESCE(SUM(b.montant), 0)) / (COALESCE(SUM(b.montant), 0) / COUNT(b.id)))\n" +
            "    END AS moisrestant\n" +
            "FROM \n" +
            "    objectifEpargne oe\n" +
            "LEFT JOIN \n" +
            "    epargne e ON oe.id = e.idObjEp\n" +
            "LEFT JOIN\n" +
            "    budget b ON e.idSortie = b.id\n" +
            "LEFT JOIN\n" +
            "    categorie c ON oe.idCategorie = c.id\n" +
            "GROUP BY \n" +
            "    oe.id, c.nom;\n")
    List<ObjEpargne> selectAll();




    /***
     * Insére un nouvel objectif d'épargne
     * @param objEpargne : objectif d'épargne à insérer
     * @return : nombre de lignes insérées
     */
    @Insert("INSERT INTO objectifEpargne(idCategorie, anneeMois, numeroMois, montant)\n" +
            "    VALUES  (#{idCategorie}, #{anneemois}, #{numeromois}, #{montant})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(ObjEpargne objEpargne);


}
