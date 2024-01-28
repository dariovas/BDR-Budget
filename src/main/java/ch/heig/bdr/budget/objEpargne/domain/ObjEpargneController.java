package ch.heig.bdr.budget.objEpargne.domain;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.categorie.repository.CategorieRepository;
import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.objEpargne.repository.ObjEpargneRepository;
import ch.heig.bdr.budget.recurrence.domain.Recurrence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/objectifEpargnes")
public class ObjEpargneController {
    private final ObjEpargneRepository repository;
    private final CategorieRepository categorieRepository;

    public ObjEpargneController(ObjEpargneRepository repository, CategorieRepository categorieRepository) {
        this.repository = repository;
        this.categorieRepository = categorieRepository;
    }

    @GetMapping("/page/{pageNo}")
    public String listPaginatedObjEpargnes(@PathVariable(value = "pageNo") int pageNo, Model model) {

        int pageSize = 3;
        List<ObjEpargne> objEpargnes = repository.getAllObjEpargnes();
        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, objEpargnes.size());

        List<ObjEpargne> objEpargnesCurrentPage = objEpargnes.subList(startIndex, endIndex);

        model.addAttribute("objEpargnes", objEpargnesCurrentPage);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", (int) Math.ceil((double) objEpargnes.size() / pageSize));
        model.addAttribute("totalItems", objEpargnes.size());

        return "objectifEpargnes";
    }

    @GetMapping
    public String viewDepenses(Model model){
        return listPaginatedObjEpargnes(1, model);
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        List<Categorie> categories = categorieRepository.getAllCategories();
        model.addAttribute("objEpargne", new ObjEpargne());
        model.addAttribute("categories", categories);
        return "ajoutObjectifEpargne";
    }

    @PostMapping("/add")
    public String add(ObjEpargne objEpargne){
        repository.addObjEpargne(objEpargne);


        return "redirect:/objectifEpargnes";
    }
}
