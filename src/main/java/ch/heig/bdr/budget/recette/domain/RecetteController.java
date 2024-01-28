package ch.heig.bdr.budget.recette.domain;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.categorie.repository.CategorieRepository;
import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.recette.repository.RecetteRepository;
import ch.heig.bdr.budget.recurrence.domain.Recurrence;
import ch.heig.bdr.budget.recurrence.repository.RecurrenceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/recettes")
public class RecetteController {
    private final RecetteRepository repository;
    private final CategorieRepository categorieRepository;
    private final RecurrenceRepository recurrenceRepository;

    public RecetteController(RecetteRepository repository, CategorieRepository categorieRepository,
                             RecurrenceRepository recurrenceRepository) {
        this.repository = repository;
        this.categorieRepository = categorieRepository;
        this.recurrenceRepository = recurrenceRepository;
    }

    @GetMapping("/page/{pageNo}")
    public String listPaginatedRecettes(@PathVariable(value = "pageNo") int pageNo, Model model) {

        int pageSize = 3;
        List<Recette> recettes = repository.getAllRecettes();
        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, recettes.size());

        List<Recette> recettesCurrentPage = recettes.subList(startIndex, endIndex);

        model.addAttribute("recettes", recettesCurrentPage);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", (int) Math.ceil((double) recettes.size() / pageSize));
        model.addAttribute("totalItems", recettes.size());

        return "recettes";
    }

    @GetMapping
    public String viewRecettes(Model model){return listPaginatedRecettes(1, model); }

    @GetMapping("/add")
    public String showAddForm(Model model){
        List<Categorie> categories = categorieRepository.getAllCategories();
        model.addAttribute("recette", new Recette());
        model.addAttribute("categories", categories);
        return "ajoutRecette";
    }
    @PostMapping("/add")
    public String add(Recette recette){
        repository.addRecette(recette);

        if(recette.getHasRecurrence()){
            Recurrence recurrence = new Recurrence();
            recurrence.setIdbudget(recette.getId());
            if(recette.getRecurrenceAnneeMois() != null){
                recurrence.setAnneemois(recette.getRecurrenceAnneeMois());
                recurrence.setNumeromois(recette.getRecurrenceNumeroMois());
                recurrence.setTouslesnmois(recette.getRecurrenceTousLesNMois());
                recurrenceRepository.addRecurrence(recurrence);
            }else {
                recurrence.setTouslesnmois(recette.getRecurrenceTousLesNMois());
                recurrenceRepository.addRecurrenceWithoutEnd(recurrence);
            }

        }

        return "redirect:/recettes";
    }
}
