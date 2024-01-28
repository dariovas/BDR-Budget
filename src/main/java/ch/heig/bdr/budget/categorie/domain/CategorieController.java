package ch.heig.bdr.budget.categorie.domain;

import ch.heig.bdr.budget.categorie.repository.CategorieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategorieController {
    private final CategorieRepository repository;

    public CategorieController(CategorieRepository categorieRepository) {
        this.repository = categorieRepository;
    }

    /***
     * Affiche la liste des catégories paginée
     * @param pageNo : numéro de la page à afficher
     * @param model  : modèle de la page
     * @return       : nom de la page à afficher
     */
    @GetMapping("/page/{pageNo}")
    public String listPaginatedCategories(@PathVariable(value = "pageNo") int pageNo, Model model) {

        // Nombre d'éléments par page
        int pageSize = 3;
        List<Categorie> categories = repository.getAllCategories();
        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, categories.size());

        // Sous-liste des catégories à afficher
        List<Categorie> categoriesCurrentPage = categories.subList(startIndex, endIndex);

        // Ajout des attributs au modèle
        model.addAttribute("categories", categoriesCurrentPage);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", (int) Math.ceil((double) categories.size() / pageSize));
        model.addAttribute("totalItems", categories.size());

        // retourne la page categories.html
        return "categories";
    }

    /**
     * Affiche la liste des catégories
     * @param model : modèle de la page
     * @return      : nom de la page à afficher
     */
    @GetMapping
    public String viewCategories(Model model){
        return listPaginatedCategories(1, model);
    }

    /***
     * Affiche le formulaire de modification d'une catégorie
     * @param model : modèle de la page
     * @return      : nom de la page à afficher
     */
    @GetMapping("/add")
    public String showAddForm(Model model){
        // Récupère la liste des catégories
        List<Categorie> categories = repository.getAllCategories();
        model.addAttribute("categorie", new Categorie());
        // Ajoute la liste des catégories au modèle
        model.addAttribute("categories", categories);
        // retourne la page ajoutCategorie.html
        return "ajoutCategorie";
    }

    /***
     * Ajoute une catégorie
     * @param categorie : catégorie à ajouter
     * @return          : nom de la page à afficher
     */
    @PostMapping("/add")
    public String add(Categorie categorie){
        // Ajoute la catégorie
        repository.addCategorie(categorie);

        // Redirige vers la page categories.html
        return "redirect:/categories";
    }

}
