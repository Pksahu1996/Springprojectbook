package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Resturant;
import com.example.demo.repository.ResturantRepository;

@Controller
public class ResturantController {

    @Autowired
    private ResturantRepository resturantRepository;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listResturants", resturantRepository.findAll());
        return "index";
    }

    @GetMapping("/showNewResturantForm")
    public String showNewResturantForm(Model model) {
        Resturant resturant = new Resturant();
        model.addAttribute("resturant", resturant);
        return "new_resturant";
    }

    @PostMapping("/saveResturant")
    public String saveResturant(@ModelAttribute("resturant") Resturant resturant) {
        resturantRepository.save(resturant);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Resturant resturant = resturantRepository.findById(id).get();
        model.addAttribute("resturant", resturant);
        return "update_resturant";
    }

    @GetMapping("/deleteResturant/{id}")
    public String deleteResturant(@PathVariable(value = "id") long id) {
        resturantRepository.deleteById(id);
        return "redirect:/";
    }
}
