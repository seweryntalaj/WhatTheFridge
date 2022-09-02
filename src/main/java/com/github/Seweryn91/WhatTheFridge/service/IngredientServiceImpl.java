package com.github.Seweryn91.WhatTheFridge.service;

import com.github.Seweryn91.WhatTheFridge.model.Ingredient;
import com.github.Seweryn91.WhatTheFridge.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public void setIngredientRepository(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }


    @Override
    public Ingredient getIngredientById(long id) {
        return ingredientRepository.findById(id).get();
    }

    @Override
    public void deleteIngredientById(long id) {
        ingredientRepository.delete(ingredientRepository.findById(id).get());
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        return ingredientRepository.findByName(name);
    }

    @Override
    public boolean isFound(long id) {
        return ingredientRepository.findById(id).isPresent();
    }
}
