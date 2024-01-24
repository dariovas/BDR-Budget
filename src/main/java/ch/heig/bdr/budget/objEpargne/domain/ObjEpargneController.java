package ch.heig.bdr.budget.objEpargne.domain;

import ch.heig.bdr.budget.objEpargne.repository.ObjEpargneRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/objepagne")
public class ObjEpargneController {
    private final ObjEpargneRepository repository;

    public ObjEpargneController(ObjEpargneRepository repository) {
        this.repository = repository;
    }
}
