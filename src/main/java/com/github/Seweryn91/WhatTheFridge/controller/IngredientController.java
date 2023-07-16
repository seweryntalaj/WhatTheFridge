package com.github.Seweryn91.WhatTheFridge.controller;

import com.github.Seweryn91.WhatTheFridge.model.Dish;
import com.github.Seweryn91.WhatTheFridge.model.Ingredient;
import com.github.Seweryn91.WhatTheFridge.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/ingredient/save")
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
        ingredientService.deleteIngredient(ingredientService.getIngredientById(id));
        return "redirect:/";
    }

    @GetMapping("ingredients/all")
    public String showAllIngredients(Model model){
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/ingredient/get/{id}")
    public String showIngredient(@PathVariable("id") long id, Model model) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        List<Dish> dishes = ingredient.getDishes().stream().sorted().toList();
        model.addAttribute("ingredient", ingredient);
        model.addAttribute("dishes", dishes);
        return "ingredient";
    }

    @GetMapping("/ingredients/all/{pageNo}")
    public String findPaginated(@PathVariable("pageNo") int pageNo, @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir, Model model) {
        int pageSize = 10;

        Page<Ingredient> page = ingredientService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Ingredient> ingredientList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("allIngredients", ingredientList);
        return "manageingredients";
    }

}
