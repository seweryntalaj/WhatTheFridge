package com.github.Seweryn91.WhatTheFridge.service;

import com.github.Seweryn91.WhatTheFridge.model.Dish;
import com.github.Seweryn91.WhatTheFridge.model.Ingredient;

import java.util.List;
import java.util.Set;

public interface DishService {

    Dish getDishById(long id);

    List<Dish> getDishList();

    Set<Ingredient> getIngredients(long dishId);

    void deleteDishById(Long dishId);

    Set<Dish> findByIngredientNamesIn(Set<String> ingredientsNames);

    Dish saveOrUpdate(Dish dish);

    Dish findByName(String name);

    Set<Dish> findSweetByIngredientNamesIn(Set<String> ingredientsNames);

    Set<Dish> findSavoryByIngredientNamesIn(Set<String> ingredientNames);

}
