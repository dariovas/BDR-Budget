package ch.heig.bdr.budget.epargne.domain;

import ch.heig.bdr.budget.epargne.repository.EpargneRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/epargnes")
public class EpargneController {
    private final EpargneRepository repository;

    public EpargneController(EpargneRepository repository) {
        this.repository = repository;
    }
}
