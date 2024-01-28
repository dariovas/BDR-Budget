package ch.heig.bdr.budget.epargne.domain;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.categorie.repository.CategorieRepository;
import ch.heig.bdr.budget.epargne.repository.EpargneRepository;
import ch.heig.bdr.budget.objEpargne.domain.ObjEpargne;
import ch.heig.bdr.budget.objEpargne.repository.ObjEpargneRepository;
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
@RequestMapping("/epargnes")
public class EpargneController {
    private final EpargneRepository repository;
    private final CategorieRepository categorieRepository;
    private final RecurrenceRepository recurrenceRepository;

    public EpargneController(EpargneRepository repository, CategorieRepository categorieRepository,
                             RecurrenceRepository recurrenceRepository) {
        this.repository = repository;
        this.categorieRepository = categorieRepository;
        this.recurrenceRepository = recurrenceRepository;
    }

    @GetMapping("/page/{pageNo}")
    public String listPaginatedEpargnes(@PathVariable(value = "pageNo") int pageNo, Model model) {

        int pageSize = 3;
        List<Epargne> epargne = repository.getAllEpargne();
        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, epargne.size());

        List<Epargne> epargnesCurrentPage = epargne.subList(startIndex, endIndex);

        model.addAttribute("epargnes", epargnesCurrentPage);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", (int) Math.ceil((double) epargne.size() / pageSize));
        model.addAttribute("totalItems", epargne.size());

        return "epargnes";
    }

    @GetMapping
    public String viewEpargnes(Model model){
        return listPaginatedEpargnes(1, model);
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        List<Categorie> categories = categorieRepository.getAllCategories();
        model.addAttribute("epargne", new Epargne());
        model.addAttribute("categories", categories);
        return "ajoutEpargne";
    }
    @PostMapping("/add")
    public String add(Epargne epargne){
        repository.addEpargne(epargne);

        if(epargne.getHasRecurrence()){
            Recurrence recurrence = new Recurrence();
            recurrence.setIdbudget(epargne.getId());
            if(epargne.getRecurrenceAnneeMois() != null){
                recurrence.setAnneemois(epargne.getRecurrenceAnneeMois());
                recurrence.setNumeromois(epargne.getRecurrenceNumeroMois());
                recurrence.setTouslesnmois(epargne.getRecurrenceTousLesNMois());
                recurrenceRepository.addRecurrence(recurrence);
            }
            recurrence.setTouslesnmois(epargne.getRecurrenceTousLesNMois());
            recurrenceRepository.addRecurrenceWithoutEnd(recurrence);

        }

        return "redirect:/epargnes";
    }
}
