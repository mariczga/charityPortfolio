package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.repositories.DonationRepository;

import java.util.List;


@Controller
public class HomeController {
    private final DonationRepository donationRepository;

    public HomeController(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        return "index";
    }

}
//TODO:ilosc instytucji i ilosc workow pobrac z respository i model attribute
//TODO:wyswietlic na index
