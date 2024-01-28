package ch.heig.bdr.budget.depense.domain;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.categorie.repository.CategorieRepository;
import ch.heig.bdr.budget.depense.repository.DepenseRepository;
import ch.heig.bdr.budget.recurrence.domain.Recurrence;
import ch.heig.bdr.budget.recurrence.repository.RecurrenceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/depenses")
public class DepenseController {
    private final DepenseRepository repository;
    private final CategorieRepository categorieRepository;
    private final RecurrenceRepository recurrenceRepository;


    public DepenseController(DepenseRepository repository, CategorieRepository categorieRepository,
                             RecurrenceRepository recurrenceRepository) {
        this.repository = repository;
        this.categorieRepository = categorieRepository;
        this.recurrenceRepository = recurrenceRepository;
    }

    /***
     * Affiche la liste des dépenses paginée
     * @param pageNo : numéro de la page à afficher
     * @param depenseSearchDTO : DTO contenant les paramètres de recherche
     * @param model : modèle de la page
     * @return : nom de la page à afficher
     */
    @GetMapping("/page/{pageNo}")
    public String listPaginatedDepenses(@PathVariable(value = "pageNo") int pageNo,
                                        @ModelAttribute DepenseSearchDTO depenseSearchDTO,
                                        Model model)  {
        int pageSize = 3;

        List<Depense> depenses = repository.getAllDepenses();

        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, depenses.size());

        // Sous-liste des dépenses à afficher
        List<Depense> depensesCurrentPage = depenses.subList(startIndex, endIndex);

        // Ajout des attributs au modèle
        model.addAttribute("depenses", depensesCurrentPage);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", (int) Math.ceil((double) depenses.size() / pageSize));
        model.addAttribute("totalItems", depenses.size());

        // retourne la page depenses.html
        return "depenses";
    }

    /***
     * Affiche la liste des dépenses
     * @param depenseSearchDTO : DTO contenant les paramètres de recherche
     * @param model : modèle de la page
     * @return : nom de la page à afficher
     */
    @GetMapping
    public String viewDepenses(@ModelAttribute DepenseSearchDTO depenseSearchDTO, Model model) {
        int pageNo = depenseSearchDTO.getPageNo();
        String beneficiaire = depenseSearchDTO.getBeneficiaire();

        return listPaginatedDepenses(pageNo, depenseSearchDTO, model);
    }

    /***
     * Recherche les dépenses correspondant aux critères de recherche
     * @return : nom de la page à afficher
     */
    @ModelAttribute("depenseSearchDTO")
    public DepenseSearchDTO depenseSearchDTO() {
        return new DepenseSearchDTO();
    }

    /**
     * Affiche le formulaire d'ajout d'une dépense
     * @param model : modèle de la page
     * @return : nom de la page à afficher
     */
    @GetMapping("/add")
    public String showAddForm(Model model){
        // Récupère la liste des catégories
        List<Categorie> categories = categorieRepository.getAllCategories();

        model.addAttribute("depense", new Depense());
        // Ajoute la liste des catégories au modèle
        model.addAttribute("categories", categories);
        // retourne la page ajoutDepense.html
        return "ajoutDepense";
    }

    /**
     * Ajoute une dépense
     * @param depense : dépense à ajouter
     * @return : nom de la page à afficher
     */
    @PostMapping("/add")
    public String add(Depense depense){
        repository.addDepense(depense);

        // Ajoute la récurrence si nécessaire
        if(depense.getHasRecurrence()){
            Recurrence recurrence = new Recurrence();
            recurrence.setIdbudget(depense.getId());
            // Vérifie si la récurrence à une date de fin
            if(depense.getRecurrenceAnneeMois() != null){
                recurrence.setAnneemois(depense.getRecurrenceAnneeMois());
                recurrence.setNumeromois(depense.getRecurrenceNumeroMois());
                recurrence.setTouslesnmois(depense.getRecurrenceTousLesNMois());
                recurrenceRepository.addRecurrence(recurrence);
            }
            recurrence.setTouslesnmois(depense.getRecurrenceTousLesNMois());
            recurrenceRepository.addRecurrenceWithoutEnd(recurrence);

        }
        // Redirige vers la page depenses.html
        return "redirect:/depenses";
    }

}
