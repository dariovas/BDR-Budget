package ch.heig.bdr.budget.revenu.domain;

import ch.heig.bdr.budget.revenu.repository.RevenuRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/revenu")
public class RevenuController {
    private final RevenuRepository repository;

    public RevenuController(RevenuRepository repository) {
        this.repository = repository;
    }
}
