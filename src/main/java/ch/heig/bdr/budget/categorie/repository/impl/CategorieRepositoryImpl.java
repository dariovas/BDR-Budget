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

    public CategorieRepositoryImpl(CategorieMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Categorie> findByNom(String nom) {
        return null;
    }

    @Override
    public List<Categorie> getAllCategories(){
        return mapper.selectAll();
    }
}
