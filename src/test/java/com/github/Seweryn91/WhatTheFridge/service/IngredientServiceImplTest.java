package com.github.Seweryn91.WhatTheFridge.service;

import com.github.Seweryn91.WhatTheFridge.model.Dish;
import com.github.Seweryn91.WhatTheFridge.model.Ingredient;
import com.github.Seweryn91.WhatTheFridge.repository.IngredientRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@DisplayName("Ingredient Service Test")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IngredientServiceImplTest {

    @Mock
    private IngredientRepository ingredientRepository;

    @InjectMocks
    private IngredientServiceImpl ingredientService;

    private DishService dishService;

    private Ingredient ingredient;

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    private Ingredient createIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("TEST");
        Set<Dish> dishes = new HashSet<>();
        dishes.add(dishService.findDishById(1));
        dishes.add(dishService.findDishById(2));
        dishes.add(dishService.findDishById(3));
        ingredient.setDishes(dishes);
        return ingredient;
    }

    @BeforeAll
    void setUp() {
        ingredient = createIngredient();
    }

    @Test
    void test_saveIngredient() {
        when(ingredientRepository.save(ingredient)).thenReturn(ingredient);
        Ingredient savedIngredient = ingredientService.saveIngredient(ingredient);
        assertEquals(savedIngredient, ingredient);
    }

    @Test
    void test_getAllIngredients() {
        when(ingredientRepository.findAll()).thenReturn(List.of(ingredient));
        assertEquals(ingredientService.getAllIngredients(), List.of(ingredient));
    }

    @Test
    void test_getIngredientById() {
        when(ingredientRepository.findById(anyLong())).thenReturn(Optional.of(ingredient));
        Ingredient foundIngredient = ingredientService.getIngredientById(1L);
        assertEquals(ingredient, foundIngredient);
    }

    @Test
    void test_deleteIngredient() {
        ingredientService.deleteIngredient(ingredient);
        verify(ingredientRepository, times(1)).delete(ingredient);
    }

    @Test
    void test_getIngredientByName() {
        when(ingredientRepository.findByName(anyString())).thenReturn(ingredient);
        Ingredient foundIngredient = ingredientService.getIngredientByName("");
        assertEquals(ingredient, foundIngredient);
    }

    @Test
    void test_isFound() {
        when(ingredientRepository.findById(anyLong())).thenReturn(Optional.of(ingredient));
        assertTrue(ingredientService.isFound(1L));
    }
}