package ch.heig.bdr.budget.sortie.domain;

import ch.heig.bdr.budget.sortie.repository.SortieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sorties")
public class SortieController {

    private final SortieRepository repository;

    public SortieController(SortieRepository repository){
        this.repository = repository;
    }

}
