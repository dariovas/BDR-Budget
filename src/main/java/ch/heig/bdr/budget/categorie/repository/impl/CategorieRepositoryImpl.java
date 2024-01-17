package ch.heig.bdr.budget.categorie.repository.impl;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.categorie.mapper.CategoryMapper;
import ch.heig.bdr.budget.categorie.repository.CategorieRepository;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class CategorieRepositoryImpl implements CategorieRepository {
    private CategoryMapper mapper;

    public CategorieRepositoryImpl(CategoryMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Categorie> findByNom(String nom) {
        return null;
    }

    @Override
    public List<Categorie> findAll(PageRequest pageRequest){
        return mapper.selectAll();
    }
}
