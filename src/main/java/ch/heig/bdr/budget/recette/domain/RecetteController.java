package ch.heig.bdr.budget.recette.domain;

import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.recette.repository.RecetteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/recettes")
public class RecetteController {
    private final RecetteRepository repository;

    public RecetteController(RecetteRepository repository) {
        this.repository = repository;
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
}
