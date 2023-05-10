package com.github.Seweryn91.WhatTheFridge.controller;

import com.github.Seweryn91.WhatTheFridge.repository.DishRepository;
import com.github.Seweryn91.WhatTheFridge.repository.IngredientRepository;
import com.github.Seweryn91.WhatTheFridge.service.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    private IngredientServiceImpl ingredientService;

    @Autowired
    DishRepository dishRepository;

    @GetMapping
    String getIngredients(Model model) {
        model.addAttribute("ingredients", ingredientService.getAllIngredients());
        return "allingredients";
    }
}
