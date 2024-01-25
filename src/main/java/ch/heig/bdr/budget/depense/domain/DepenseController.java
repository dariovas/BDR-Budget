package ch.heig.bdr.budget.depense.domain;


import ch.heig.bdr.budget.depense.repository.DepenseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/depenses")
public class DepenseController {
    private final DepenseRepository repository;

    public DepenseController(DepenseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/page/{pageNo}")
    public String listPaginatedDepenses(@PathVariable(value = "pageNo") int pageNo, Model model) {

        int pageSize = 3;
        List<Depense> depenses = repository.getAllDepenses();
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
    public String viewDepenses(Model model){
        return listPaginatedDepenses(1, model);
    }

}
