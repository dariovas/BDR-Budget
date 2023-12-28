package ch.heig.bdr.budget.categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategorieController {
    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping("/categories/page/{pageNo}")
    public String listPaginatedCategories(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 3;
        Page<Categorie> categoriePage = categorieRepository.findAll(PageRequest.of(pageNo - 1, pageSize));
        List<Categorie> categories = categoriePage.getContent();

        model.addAttribute("categories", categories);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", categoriePage.getTotalPages());
        model.addAttribute("totalItems", categoriePage.getTotalElements());

        return "categories";
    }

    @GetMapping("/categories")
    public String viewCategories(Model model){
        return listPaginatedCategories(1, model);
    }

}
