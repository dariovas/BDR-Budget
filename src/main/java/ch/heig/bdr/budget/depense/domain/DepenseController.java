package ch.heig.bdr.budget.depense.domain;


import ch.heig.bdr.budget.depense.repository.DepenseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/depenses")
public class DepenseController {
    private final DepenseRepository repository;

    public DepenseController(DepenseRepository repository) {
        this.repository = repository;
    }
}
