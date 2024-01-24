package ch.heig.bdr.budget.bdgt.domain;

import ch.heig.bdr.budget.bdgt.repository.BudgetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/budget")
public class BudgetController {
    private final BudgetRepository repository;
    public BudgetController(BudgetRepository repository) {
        this.repository = repository;
    }
}
