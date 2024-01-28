package ch.heig.bdr.budget.revenu.domain;
import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.categorie.repository.CategorieRepository;
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

    public RevenuController(RevenuRepository repository, CategorieRepository categorieRepository) {
        this.repository = repository;
        this.categorieRepository = categorieRepository;
    }

    @GetMapping("/page/{pageNo}")
    public String listPaginatedRevenus(@PathVariable(value = "pageNo") int pageNo, Model model) {

        int pageSize = 3;
        List<Revenu> revenus = repository.getAllRevenus();
        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, revenus.size());

        List<Revenu> revenusCurrentPage = revenus.subList(startIndex, endIndex);

        model.addAttribute("revenus", revenusCurrentPage);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", (int) Math.ceil((double) revenus.size() / pageSize));
        model.addAttribute("totalItems", revenus.size());

        return "revenus";
    }

    @GetMapping
    public String viewRevenus(Model model){
        return listPaginatedRevenus(1, model);
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        List<Categorie> categories = categorieRepository.getAllCategories();
        model.addAttribute("revenu", new Revenu());
        model.addAttribute("categories", categories);
        return "ajoutRevenu";
    }

    @PostMapping("/add")
    public String add(Revenu revenu){
        repository.addRevenus(revenu);

        return "redirect:/revenus";
    }

}
