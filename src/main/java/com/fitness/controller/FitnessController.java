package com.fitness.controller;



import com.fitness.model.Fitness;
import com.fitness.serviceLayer.FitnessService;

import com.fitness.serviceLayer.UserNotFoundExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
public class FitnessController {
    @Autowired
    private FitnessService service;

    @GetMapping("/fitnesses")
    public String ShowFitnessList(Model model) {

        List<Fitness> listFitnesses= service.listAll();
        model.addAttribute("listFitnesses",  listFitnesses);

        return "fitnesses";
    }

    @GetMapping("/fitnesses/new")
    public String ShowFitnessForm( Model model){

        model.addAttribute("fitness", new Fitness());
        return "fitness_form";
    }

    @PostMapping("/fitnesses/new")
    public String saveFitness(@ModelAttribute Fitness fitness, RedirectAttributes ra){
        service.save(fitness);
        return "redirect:/fitnesses";

    }

    @GetMapping("/fitnesses/edit/{id}")
    public  String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){

        try {
            Fitness fitness= service.get(id);
            model.addAttribute("fitness", fitness);
            model.addAttribute("pageTitle", "Edit Fitness (ID "+ id +")");
            return "fitness_form";
        }
         catch (UserNotFoundExcpetion e) {
            ra.addAttribute("message", e.getMessage());

        }
        return "redirect:/fitnesses";

    }

    @GetMapping("/fitnesses/delete/{id}")
    public  String DeleteFitness(@PathVariable("id") Integer id, RedirectAttributes ra){

        try {
                service.delete(id);

        }
        catch (UserNotFoundExcpetion e) {
            ra.addAttribute("message", e.getMessage());

        }
        return "redirect:/fitnesses";

    }

}
