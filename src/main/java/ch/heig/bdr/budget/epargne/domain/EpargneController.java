package ch.heig.bdr.budget.epargne.domain;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.categorie.repository.CategorieRepository;
import ch.heig.bdr.budget.epargne.repository.EpargneRepository;
import ch.heig.bdr.budget.objEpargne.domain.ObjEpargne;
import ch.heig.bdr.budget.objEpargne.repository.ObjEpargneRepository;
import ch.heig.bdr.budget.recurrence.domain.Recurrence;
import ch.heig.bdr.budget.recurrence.repository.RecurrenceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/epargnes")
public class EpargneController {
    private final EpargneRepository repository;
    private final CategorieRepository categorieRepository;
    private final RecurrenceRepository recurrenceRepository;

    public EpargneController(EpargneRepository repository, CategorieRepository categorieRepository,
                             RecurrenceRepository recurrenceRepository) {
        this.repository = repository;
        this.categorieRepository = categorieRepository;
        this.recurrenceRepository = recurrenceRepository;
    }

    /***
     * Affiche la liste des épargnes paginée
     * @param pageNo :  numéro de la page à afficher
     * @param model : modèle de la page
     * @return : nom de la page à afficher
     */
    @GetMapping("/page/{pageNo}")
    public String listPaginatedEpargnes(@PathVariable(value = "pageNo") int pageNo, Model model) {

        // Nombre d'éléments par page
        int pageSize = 3;
        List<Epargne> epargne = repository.getAllEpargne();
        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, epargne.size());

        // Sous-liste des épargnes à afficher
        List<Epargne> epargnesCurrentPage = epargne.subList(startIndex, endIndex);
        // Ajout des attributs au modèle
        model.addAttribute("epargnes", epargnesCurrentPage);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", (int) Math.ceil((double) epargne.size() / pageSize));
        model.addAttribute("totalItems", epargne.size());
        // retourne la page epargnes.html
        return "epargnes";
    }

    /***
     * Affiche la liste des épargnes
     * @param model : modèle de la page
     * @return : nom de la page à afficher
     */
    @GetMapping
    public String viewEpargnes(Model model){
        return listPaginatedEpargnes(1, model);
    }

    /***
     * Affiche le formulaire d'ajout d'une épargne
     * @param model : modèle de la page
     * @return : nom de la page à afficher
     */
    @GetMapping("/add")
    public String showAddForm(Model model){
        // Récupère la liste des catégories
        List<Categorie> categories = categorieRepository.getAllCategories();
        // Ajout des attributs au modèle
        model.addAttribute("epargne", new Epargne());
        model.addAttribute("categories", categories);
        // retourne la page ajoutEpargne.html
        return "ajoutEpargne";
    }

    /***
     * Ajoute une nouvelle épargne
     * @param epargne : épargne à ajouter
     * @return : nom de la page à afficher
     */
    @PostMapping("/add")
    public String add(Epargne epargne){
        repository.addEpargne(epargne);

        // Ajout de la récurrence
        if(epargne.getHasRecurrence()){
            Recurrence recurrence = new Recurrence();
            recurrence.setIdbudget(epargne.getId());
            // Vérifie si la récurrence a une fin
            if(epargne.getRecurrenceAnneeMois() != null){
                recurrence.setAnneemois(epargne.getRecurrenceAnneeMois());
                recurrence.setNumeromois(epargne.getRecurrenceNumeroMois());
                recurrence.setTouslesnmois(epargne.getRecurrenceTousLesNMois());
                recurrenceRepository.addRecurrence(recurrence);
            }else{
                recurrence.setTouslesnmois(epargne.getRecurrenceTousLesNMois());
                recurrenceRepository.addRecurrenceWithoutEnd(recurrence);
            }


        }
        // retourne la page epargnes.html
        return "redirect:/epargnes";
    }
}
