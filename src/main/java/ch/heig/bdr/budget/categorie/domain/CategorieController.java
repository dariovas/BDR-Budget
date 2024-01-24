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
    private final CategorieRepository categorieRepository;

    public CategorieController(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @GetMapping("/page/{pageNo}")
    public String listPaginatedCategories(@PathVariable(value = "pageNo") int pageNo, Model model) {

        int pageSize = 3;
        List<Categorie> categories = categorieRepository.getAllCategories();
        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, categories.size());

        List<Categorie> categoriesCurrentPage = categories.subList(startIndex, endIndex);

        model.addAttribute("categories", categoriesCurrentPage);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", (int) Math.ceil((double) categories.size() / pageSize));
        model.addAttribute("totalItems", categories.size());

        return "categories";
    }

    @GetMapping
    public String viewCategories(Model model){
        return listPaginatedCategories(1, model);
    }


    /**
    @PostMapping()
    public Categorie add(Categorie categorie);
    **/

}
