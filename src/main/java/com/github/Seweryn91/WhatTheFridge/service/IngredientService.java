package com.github.Seweryn91.WhatTheFridge.service;

import com.github.Seweryn91.WhatTheFridge.model.Ingredient;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IngredientService {

    Ingredient saveIngredient(Ingredient ingredient);

    List<Ingredient> getAllIngredients();

    Ingredient getIngredientById(long id);

    void deleteIngredient(Ingredient ingredient);

    Ingredient getIngredientByName(String name);

    boolean isFound(long id);

    Page<Ingredient> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
