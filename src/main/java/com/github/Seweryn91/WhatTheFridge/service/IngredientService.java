package com.github.Seweryn91.WhatTheFridge.service;

import com.github.Seweryn91.WhatTheFridge.model.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient saveIngredient(Ingredient ingredient);

    List<Ingredient> getAllIngredients();

    Ingredient getIngredientById(long id);

    void deleteIngredient(Ingredient ingredient);

    Ingredient getIngredientByName(String name);

    boolean isFound(long id);

}
