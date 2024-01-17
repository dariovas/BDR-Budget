package ch.heig.bdr.budget.categorie.repository;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategorieRepository {
    List<Categorie> findByNom(String nom);
    List<Categorie> findAll(PageRequest pageRequest);
}