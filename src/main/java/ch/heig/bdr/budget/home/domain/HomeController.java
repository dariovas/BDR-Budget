package ch.heig.bdr.budget.home.domain;

import ch.heig.bdr.budget.home.repository.HomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final HomeRepository repository;

    public HomeController(HomeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String homePage(Model model) {
        Home homeData = repository.getAllHomes();
        model.addAttribute("home", homeData);
        return "home";
    }
}
