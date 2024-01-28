package ch.heig.bdr.budget.revenu.domain;
import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.categorie.repository.CategorieRepository;
import ch.heig.bdr.budget.recurrence.domain.Recurrence;
import ch.heig.bdr.budget.recurrence.repository.RecurrenceRepository;
import ch.heig.bdr.budget.revenu.repository.RevenuRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/revenus")
public class RevenuController {
    private final RevenuRepository repository;
    private final CategorieRepository categorieRepository;
    private final RecurrenceRepository recurrenceRepository;

    public RevenuController(RevenuRepository repository, CategorieRepository categorieRepository,
                            RecurrenceRepository recurrenceRepository) {
        this.repository = repository;
        this.categorieRepository = categorieRepository;
        this.recurrenceRepository = recurrenceRepository;
    }

    /***
     * Affiche la liste des revenus paginée
     * @param pageNo : numéro de la page à afficher
     * @param model : modèle de la page
     * @return : nom de la page à afficher
     */
    @GetMapping("/page/{pageNo}")
    public String listPaginatedRevenus(@PathVariable(value = "pageNo") int pageNo, Model model) {

        // Nombre d'éléments par page
        int pageSize = 3;
        List<Revenu> revenus = repository.getAllRevenus();
        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, revenus.size());
        List<Revenu> revenusCurrentPage = revenus.subList(startIndex, endIndex);

        // Ajout des attributs au modèle
        model.addAttribute("revenus", revenusCurrentPage);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", (int) Math.ceil((double) revenus.size() / pageSize));
        model.addAttribute("totalItems", revenus.size());

        // retourne la page revenus.html
        return "revenus";
    }

    /***
     * Affiche la liste des revenus
     * @param model : modèle de la page
     * @return : nom de la page à afficher
     */
    @GetMapping
    public String viewRevenus(Model model){
        return listPaginatedRevenus(1, model);
    }

    /***
     * Affiche le formulaire d'ajout d'un revenu
     * @param model : modèle de la page
     * @return : nom de la page à afficher
     */
    @GetMapping("/add")
    public String showAddForm(Model model){
        List<Categorie> categories = categorieRepository.getAllCategories();
        model.addAttribute("revenu", new Revenu());
        model.addAttribute("categories", categories);
        return "ajoutRevenu";
    }

    /***
     * Ajoute un revenu
     * @param revenu : revenu à ajouter
     * @return : nom de la page à afficher
     */
    @PostMapping("/add")
    public String add(Revenu revenu){
        // Ajout du revenu
        repository.addRevenus(revenu);

        // Si le revenu a une récurrence, on l'ajoute
        if(revenu.getHasRecurrence()){
            Recurrence recurrence = new Recurrence();
            recurrence.setIdbudget(revenu.getId());
            // Si la récurrence n'a pas de fin
            if(revenu.getRecurrenceAnneeMois() != null){
                recurrence.setAnneemois(revenu.getRecurrenceAnneeMois());
                recurrence.setNumeromois(revenu.getRecurrenceNumeroMois());
                recurrence.setTouslesnmois(revenu.getRecurrenceTousLesNMois());
                recurrenceRepository.addRecurrence(recurrence);
            }else {
                recurrence.setTouslesnmois(revenu.getRecurrenceTousLesNMois());
                recurrenceRepository.addRecurrenceWithoutEnd(recurrence);
            }

        }

        // Redirection vers la page revenus.html
        return "redirect:/revenus";
    }

}
