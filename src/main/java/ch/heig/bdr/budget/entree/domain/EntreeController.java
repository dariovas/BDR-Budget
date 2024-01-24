package ch.heig.bdr.budget.entree.domain;

import ch.heig.bdr.budget.entree.repository.EntreeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/entrees")
public class EntreeController {
    private final EntreeRepository repository;

    public EntreeController(EntreeRepository repository){
        this.repository = repository;
    }
}
