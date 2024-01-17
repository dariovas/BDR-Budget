package ch.heig.bdr.budget.categorie.domain;

import ch.heig.bdr.budget.categorie.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller("/categories")
public class CategorieController {
    private final CategorieRepository categorieRepository;

    public CategorieController(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @GetMapping("page/{pageNo}")
    public String listPaginatedCategories(@PathVariable(value = "pageNo") int pageNo, Model model) {
        /**
        int pageSize = 3;
        Page<Categorie> categoriePage = categorieRepository.findAll(PageRequest.of(pageNo - 1, pageSize));
        List<Categorie> categories = categoriePage.getContent();

        model.addAttribute("categories", categories);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", categoriePage.getTotalPages());
        model.addAttribute("totalItems", categoriePage.getTotalElements());

         **/
        return "categories";
    }

    @GetMapping()
    public String viewCategories(Model model){
        return listPaginatedCategories(1, model);
    }


    /**
    @PostMapping()
    public Categorie add(Categorie categorie);
    **/
}
