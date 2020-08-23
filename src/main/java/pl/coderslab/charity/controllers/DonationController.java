package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;

import java.util.List;
@Controller
public class DonationController {

    private final InstitutionRepository institutionRepository;

    private final CategoryRepository categoryRepository;

    public DonationController(InstitutionRepository institutionRepository, CategoryRepository categoryRepository) {
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/form")
    public String getList (Model model) {
        List<Institution> institution = this.institutionRepository.findAll();
        model.addAttribute("institution", institution);
        List<Category> category = this.categoryRepository.findAll();
        model.addAttribute("category", category);
        return "form";

    }
//    @RequestMapping(value = "/form", method = RequestMethod.GET)
//    public String getForm(Model model){
//        model.addAttribute("donation", new Donation());
//        return "form";
//    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public Donation createDonation(@ModelAttribute Donation donation){
        return donation;
    }



    @RequestMapping("/form-confirmation")
    public String formConfirmationAction(){return "form-confirmation";}

    //TODO:get donation form - oblusge fromularza, post - pobieranie danych z fronta
}

//TODO:Tdobrze podpiac css i dobrze podpiac javascript w widoku radio buttony i check boxy maja byc zrobione tagami html reszta tagami jsp
