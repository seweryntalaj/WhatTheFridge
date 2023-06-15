package com.github.Seweryn91.WhatTheFridge.controller;

import com.github.Seweryn91.WhatTheFridge.model.Ingredient;
import com.github.Seweryn91.WhatTheFridge.repository.DishRepository;
import com.github.Seweryn91.WhatTheFridge.repository.IngredientRepository;
import com.github.Seweryn91.WhatTheFridge.service.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    private IngredientServiceImpl ingredientService;

    @Autowired
    DishRepository dishRepository;

    @GetMapping("/allingredients")
    String getIngredients(Model model) {
        List<Ingredient> allIngredients = ingredientService.getAllIngredients();
        Collections.sort(allIngredients);
        model.addAttribute("ingredients", allIngredients);
        return "allingredients";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/logout")
    String logout() { return "logout"; }

    @GetMapping("/")
    String index() { return "index"; }

}
