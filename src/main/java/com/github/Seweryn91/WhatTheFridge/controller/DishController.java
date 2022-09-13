package com.github.Seweryn91.WhatTheFridge.controller;

import com.github.Seweryn91.WhatTheFridge.model.Dish;
import com.github.Seweryn91.WhatTheFridge.model.Ingredient;
import com.github.Seweryn91.WhatTheFridge.service.DishService;
import com.github.Seweryn91.WhatTheFridge.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/dish/new")
    public String addNewDish(Model model) {
        model.addAttribute("dish", new Dish());
        model.addAttribute("ingredients", ingredientService.getAllIngredients());
        return "newdish";
    }

    @GetMapping("/dish/get/{id}")
    public String getDish(@PathVariable("id") long id, Model model) {
        Dish dish = dishService.getDishById(id);
        model.addAttribute("dish", dish);
        List<Ingredient> ingredientsSorted = dish.getIngredients().stream().sorted().toList();
        model.addAttribute("ingredients", ingredientsSorted);
        return "dish";
    }
    
    @GetMapping("/dish/delete/{id}")
    public String deleteDish(@PathVariable("id") long id) {
        dishService.deleteDishById(id);
        return "redirect:/";
    }

}
