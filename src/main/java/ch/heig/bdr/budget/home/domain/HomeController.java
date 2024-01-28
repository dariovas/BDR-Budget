package ch.heig.bdr.budget.home.domain;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.home.repository.HomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final HomeRepository repository;

    public HomeController(HomeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/page/{pageNo}")
    public String listPaginatedHome(@PathVariable(value = "pageNo") int pageNo, Model model) {

        int pageSize = 3;
        List<Home> homeData = repository.getTotalByMonth();
        Home homeAvgLast12Month = repository.getAvgLast12Month();

        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, homeData.size());

        List<Home> homeCurrentPage = homeData.subList(startIndex, endIndex);

        model.addAttribute("homes", homeCurrentPage);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", (int) Math.ceil((double) homeData.size() / pageSize));
        model.addAttribute("totalItems", homeData.size());

        model.addAttribute("homesAvg", homeAvgLast12Month);

        return "home";
    }

    @GetMapping
    public String homePage(Model model){
        return listPaginatedHome(1, model);
    }

}
