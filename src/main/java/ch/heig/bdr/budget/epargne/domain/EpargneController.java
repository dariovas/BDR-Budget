package ch.heig.bdr.budget.epargne.domain;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.epargne.repository.EpargneRepository;
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

    public EpargneController(EpargneRepository repository) {
        this.repository = repository;
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
        model.addAttribute("epargne", new Epargne());
        return "ajoutEpargne";
    }
    @PostMapping("/add")
    public String add(Epargne epargne){
        repository.addEpargne(epargne);

        return "redirect:/epargnes";
    }
}
