package ch.heig.bdr.budget.categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    List<Categorie> findByNom(String nom);
}