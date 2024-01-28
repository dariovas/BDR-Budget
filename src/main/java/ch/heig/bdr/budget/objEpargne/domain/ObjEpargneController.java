package ch.heig.bdr.budget.objEpargne.domain;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.categorie.repository.CategorieRepository;
import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.objEpargne.repository.ObjEpargneRepository;
import ch.heig.bdr.budget.recurrence.domain.Recurrence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/objectifEpargnes")
public class ObjEpargneController {
    private final ObjEpargneRepository repository;
    private final CategorieRepository categorieRepository;

    public ObjEpargneController(ObjEpargneRepository repository, CategorieRepository categorieRepository) {
        this.repository = repository;
        this.categorieRepository = categorieRepository;
    }

    /**
     * Affiche la liste des objectifs d'épargne paginée
     * @param pageNo : numéro de la page à afficher
     * @param model : modèle de la page
     * @return : nom de la page à afficher
     */
    @GetMapping("/page/{pageNo}")
    public String listPaginatedObjEpargnes(@PathVariable(value = "pageNo") int pageNo, Model model) {


        // Nombre d'éléments par page
        int pageSize = 3;
        List<ObjEpargne> objEpargnes = repository.getAllObjEpargnes();
        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, objEpargnes.size());

        // Sous-liste des objectifs d'épargne à afficher
        List<ObjEpargne> objEpargnesCurrentPage = objEpargnes.subList(startIndex, endIndex);

        // Ajout des attributs au modèle
        model.addAttribute("objEpargnes", objEpargnesCurrentPage);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", (int) Math.ceil((double) objEpargnes.size() / pageSize));
        model.addAttribute("totalItems", objEpargnes.size());

        // retourne la page objectifEpargnes.html
        return "objectifEpargnes";
    }

    /***
     * Affiche la liste des objectifs d'épargne
     * @param model :   modèle de la page
     * @return :       nom de la page à afficher
     */
    @GetMapping
    public String viewDepenses(Model model){
        return listPaginatedObjEpargnes(1, model);
    }

    /**
     * Affiche le formulaire d'ajout d'un objectif d'épargne
     * @param model : modèle de la page
     * @return : nom de la page à afficher
     */
    @GetMapping("/add")
    public String showAddForm(Model model){
        List<Categorie> categories = categorieRepository.getAllCategories();
        model.addAttribute("objEpargne", new ObjEpargne());
        model.addAttribute("categories", categories);
        // retourne la page ajoutObjectifEpargne.html
        return "ajoutObjectifEpargne";
    }

    /**
     * Ajoute un objectif d'épargne
     * @param objEpargne : objectif d'épargne à ajouter
     * @return : nom de la page à afficher
     */
    @PostMapping("/add")
    public String add(ObjEpargne objEpargne){
        repository.addObjEpargne(objEpargne);

        // retourne la page objectifEpargnes.html
        return "redirect:/objectifEpargnes";
    }
}
