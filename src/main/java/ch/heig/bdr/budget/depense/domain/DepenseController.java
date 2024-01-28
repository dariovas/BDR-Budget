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

    @GetMapping("/page/{pageNo}")
    public String listPaginatedDepenses(@PathVariable(value = "pageNo") int pageNo,
                                        @RequestParam(name = "beneficiaire", required = false) String beneficiaire,
                                        Model model)  {
        int pageSize = 3;

        List<Depense> depenses;
        if (beneficiaire != null && !beneficiaire.isEmpty()) {
            // Si un bénéficiaire est fourni, filtrer les résultats
            depenses = repository.searchDepenseByBeneficiaire(beneficiaire);
        } else {
            // Sinon, obtenir toutes les dépenses
            depenses = repository.getAllDepenses();
        }

        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, depenses.size());

        List<Depense> depensesCurrentPage = depenses.subList(startIndex, endIndex);

        model.addAttribute("depenses", depensesCurrentPage);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", (int) Math.ceil((double) depenses.size() / pageSize));
        model.addAttribute("totalItems", depenses.size());

        return "depenses";
    }

    @GetMapping
    public String viewDepenses(@ModelAttribute DepenseSearchDTO depenseSearchDTO, Model model) {
        return listPaginatedDepenses(depenseSearchDTO.getPageNo(), depenseSearchDTO.getBeneficiaire(), model);
    }
    @ModelAttribute("depenseSearchDTO")
    public DepenseSearchDTO depenseSearchDTO() {
        return new DepenseSearchDTO();
    }
    @GetMapping("/add")
    public String showAddForm(Model model){
        List<Categorie> categories = categorieRepository.getAllCategories();
        model.addAttribute("depense", new Depense());
        model.addAttribute("categories", categories);
        return "ajoutDepense";
    }
    @PostMapping("/add")
    public String add(Depense depense){
        repository.addDepense(depense);

        if(depense.getHasRecurrence()){
            Recurrence recurrence = new Recurrence();
            recurrence.setIdbudget(depense.getId());
            if(depense.getRecurrenceAnneeMois() != null){
                recurrence.setAnneemois(depense.getRecurrenceAnneeMois());
                recurrence.setNumeromois(depense.getRecurrenceNumeroMois());
                recurrence.setTouslesnmois(depense.getRecurrenceTousLesNMois());
                recurrenceRepository.addRecurrence(recurrence);
            }else{
                recurrence.setTouslesnmois(depense.getRecurrenceTousLesNMois());
                recurrenceRepository.addRecurrenceWithoutEnd(recurrence);
            }
        }
        return "redirect:/depenses";
    }

}
