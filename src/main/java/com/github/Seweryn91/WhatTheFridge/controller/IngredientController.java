package com.github.Seweryn91.WhatTheFridge.controller;

import com.github.Seweryn91.WhatTheFridge.model.Ingredient;
import com.github.Seweryn91.WhatTheFridge.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/ingredient/new")
    public String createIngredient(Model model) {
        Ingredient ingredient = new Ingredient();
        model.addAttribute("ingredient", ingredient);
        return "newingredient";
    }

    @PostMapping("ingredient/save")
    public String saveIngredient(@ModelAttribute("ingredient") Ingredient ingredient) {
        ingredientService.saveIngredient(ingredient);
        return "redirect:/";
    }

    @GetMapping("/ingredient/update/{id}")
    public String updateIngredient(@PathVariable("id") long id, Model model) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        model.addAttribute("ingredient", ingredient);
        return "updateingredient";
    }
    
    @GetMapping("/ingredient/delete/{id}")
    public String deleteIngredient(@PathVariable("id") long id) {
        ingredientService.deleteIngredientById(id);
        return "redirect:/";
    }
}
