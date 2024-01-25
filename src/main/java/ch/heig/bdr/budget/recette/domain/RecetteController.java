package ch.heig.bdr.budget.recette.domain;

import ch.heig.bdr.budget.recette.repository.RecetteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recette")
public class RecetteController {
    private final RecetteRepository repository;

    public RecetteController(RecetteRepository repository) {
        this.repository = repository;
    }
}
