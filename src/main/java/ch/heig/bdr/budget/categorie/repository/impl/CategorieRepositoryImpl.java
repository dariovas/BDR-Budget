package ch.heig.bdr.budget.categorie.repository.impl;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.categorie.mapper.CategorieMapper;
import ch.heig.bdr.budget.categorie.repository.CategorieRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategorieRepositoryImpl implements CategorieRepository {
    private CategorieMapper mapper;

    // Constructeur
    public CategorieRepositoryImpl(CategorieMapper mapper) {
        this.mapper = mapper;
    }

    /***
     * Retourne une catégorie par son id
     * @param nom : nom de la catégorie à retourner
     * @return : catégorie correspondante
     */
    @Override
    public List<Categorie> findByNom(String nom) {
        return null;
    }

    /***
     * Retourne toutes les catégories
     * @return : toutes les catégories
     */
    @Override
    public List<Categorie> getAllCategories(){
        return mapper.selectAll();
    }

    /***
     * Ajoute une nouvelle catégorie
     * @param categorie : catégorie à ajouter
     */
    @Override
    public void addCategorie(Categorie categorie) {
        mapper.insert(categorie);
    }


}
