package com.github.Seweryn91.WhatTheFridge.service;

import com.github.Seweryn91.WhatTheFridge.model.Dish;
import com.github.Seweryn91.WhatTheFridge.model.Ingredient;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface DishService {

    Dish findDishById(long id);

    List<Dish> getDishList();

    Set<Ingredient> getIngredients(long dishId);

    void delete(Dish dish);

    List<Dish> findByIngredientNamesIn(Set<String> ingredientsNames);

    Dish saveOrUpdate(Dish dish);

    Dish findByName(String name);

    List<Dish> findSweetByIngredientNamesIn(Set<String> ingredientsNames);

    List<Dish> findSavoryByIngredientNamesIn(Set<String> ingredientNames);

    Page<Dish> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
