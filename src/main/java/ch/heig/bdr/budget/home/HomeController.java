package ch.heig.bdr.budget.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage() {
        return "home"; // Correspond au nom du fichier HTML (sans extension)
    }
}
