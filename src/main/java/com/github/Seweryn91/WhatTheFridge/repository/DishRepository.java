package com.github.Seweryn91.WhatTheFridge.repository;

import com.github.Seweryn91.WhatTheFridge.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    @Query(value = "SELECT d.id, d.name, d.sweetdish, d.picturelink, d.recipelink FROM Dish AS d LEFT JOIN " +
            "dish_ingredient AS di ON d.id = di.fk_dish_id LEFT JOIN ingredient AS i ON di.fk_ingredient_id = i.id " +
            "WHERE i.name IN :names ORDER BY d.name ASC", nativeQuery = true)
    Set<Dish> findByIngredientNamesIn(@Param("names") Set<String> ingredientNames);

    @Query(value = "SELECT d.id, d.name, d.sweetdish, d.picturelink, d.recipelink FROM Dish AS d LEFT JOIN " +
            "dish_ingredient AS di ON d.id = di.fk_dish_id LEFT JOIN ingredient AS i ON di.fk_ingredient_id = i.id " +
            "WHERE i.name IN :names AND sweetdish = TRUE ORDER BY d.name ASC", nativeQuery = true)
    Set<Dish> findSweetByIngredientNamesIn(@Param("names") Set<String> ingredientNames);

    @Query(value = "SELECT d.id, d.name, d.sweetdish, d.picturelink, d.recipelink FROM Dish AS d LEFT JOIN " +
            "dish_ingredient AS di ON d.id = di.fk_dish_id LEFT JOIN ingredient AS i ON di.fk_ingredient_id = i.id " +
            "WHERE i.name IN :names AND sweetdish = FALSE ORDER BY d.name ASC", nativeQuery = true)
    Set<Dish> findSavoryByIngredientNamesIn(@Param("names") Set<String> ingredientNames);

    Dish findByName(String name);
}
