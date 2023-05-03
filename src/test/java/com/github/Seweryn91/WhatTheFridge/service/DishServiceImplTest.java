package com.github.Seweryn91.WhatTheFridge.service;

import com.github.Seweryn91.WhatTheFridge.model.Ingredient;
import com.github.Seweryn91.WhatTheFridge.model.Dish;
import com.github.Seweryn91.WhatTheFridge.repository.DishRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@DisplayName("Dish Service Test")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DishServiceImplTest {

    @Mock
    private DishRepository dishRepository;

    @InjectMocks
    private DishServiceImpl dishService;

    private IngredientService ingredientService;

    private Dish dish;

    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    private Dish createDish() {
        Dish dish = new Dish();
        dish.setName("TEST");
        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(ingredientService.getIngredientById(1));
        ingredients.add(ingredientService.getIngredientById(2));
        ingredients.add(ingredientService.getIngredientById(3));
        dish.setIngredients(ingredients);
        dish.setSweetDish(false);
        dish.setPictureLink("LINK");
        dish.setRecipeLink("LINK");
        return dish;
    }

    @BeforeAll
    public void setUp() {
        dish = createDish();
    }

    public Set<Ingredient> createIngredientsSet() {
        Set<Ingredient> ingredients = new HashSet<>();
        Ingredient i1 = new Ingredient();
        i1.setName("Ingredient1");
        ingredients.add(i1);
        Ingredient i2 = new Ingredient();
        i2.setName("Ingredient2");
        ingredients.add(i2);
        Ingredient i3 = new Ingredient();
        i3.setName("Ingredient3");
        ingredients.add(i3);
        return ingredients;
    }

    public Set<Dish> createDishSet() {
        Set<Ingredient> ingredients = createIngredientsSet();
        Set<Dish> dishes = new HashSet<>();
        Dish dish1 = new Dish();
        dish1.setName("Savory Dish");
        dish1.setSweetDish(false);
        dish1.setIngredients(ingredients);
        dishes.add(dish1);
        Dish dish2 = new Dish();
        dish2.setName("Sweet Dish");
        dish2.setSweetDish(true);
        dish2.setIngredients(ingredients);
        dishes.add(dish2);
        return dishes;
    }

    @Test
    public void test_saveDish() {
      when(dishRepository.save(dish)).thenReturn(dish);
      Dish savedDish = dishService.saveOrUpdate(dish);
      assertEquals(savedDish, dish);
    }

    @Test
    public void test_updateDish() {
        when(dishRepository.save(dish)).thenReturn(dish);
        Dish savedDish = dishService.saveOrUpdate(dish);
        System.out.println(dish.getId());
        assertEquals(savedDish, dish);
        dish.setName("New Name");
        when(dishRepository.save(dish)).thenReturn(dish);
        assertEquals("New Name", dishService.saveOrUpdate(dish).getName());
    }

    @Test
    public void test_deleteDish() {
        dishService.delete(dish);
        verify(dishRepository, times(1)).delete(dish);
    }

    @Test
    public void test_getDishList() {
      List<Dish> dishes = createDishSet().stream().toList();
      when(dishRepository.findAll()).thenReturn(dishes);
      assertEquals(dishes, dishService.getDishList());
    }

    @Test
    public void test_getDishById() {
        when(dishRepository.findById(anyLong())).thenReturn(Optional.of(dish));
        Dish foundDish = dishService.findDishById(1L);
        assertEquals(dish, foundDish);
    }

    @Test
    public void test_getDishByName() {
        when(dishRepository.findByName(anyString())).thenReturn(dish);
        Dish foundDish = dishService.findByName("");
        assertEquals(dish, foundDish);
    }

    @Test
    public void test_findDishById_throwsException() {
      assertThrows(RuntimeException.class, () -> dishService.findDishById(-1L) );
    }

    @Test
    public void test_getIngredients() {
      Dish mock = new Dish();
      Ingredient ingredient = new Ingredient();
      ingredient.setName("test");
      Set<Ingredient> ingredients = new HashSet<>();
      ingredients.add(ingredient);
      mock.setIngredients(ingredients);
      when(dishRepository.findById(anyLong())).thenReturn(Optional.of(mock));
      assertEquals(ingredients, dishService.getIngredients(1L));
    }

    @Test
    public void test_findByIngredientsNameIn() {
        Set<Ingredient> ingredients = createIngredientsSet();
        Set<Dish> dishes = createDishSet();
        String anyIngredientName = ingredients.stream().findFirst().get().getName();
        when(dishRepository.findByIngredientNamesIn(Set.of(anyIngredientName))).thenReturn(dishes);
        assertEquals(dishes ,dishService.findByIngredientNamesIn(Set.of(anyIngredientName)));
    }

    @Test
    public void test_findSweetByIngredientsNameIn() {
      Set<Dish> dishes = createDishSet();
      Set<Ingredient> ingredients = createIngredientsSet();
      Set<Dish> expected = dishes.stream().filter(Dish::isSweetDish).collect(Collectors.toSet());
      String anyIngredientName = ingredients.stream().findFirst().get().getName();
      when(dishRepository.findSweetByIngredientNamesIn(Set.of(anyIngredientName))).thenReturn(expected);
      assertEquals(expected, dishService.findSweetByIngredientNamesIn(Set.of(anyIngredientName)));
  }

    @Test
    public void test_findSavoryByIngredientsNameIn() {
        Set<Dish> dishes = createDishSet();
        Set<Ingredient> ingredients = createIngredientsSet();
        String anyIngredientName = ingredients.stream().findFirst().get().getName();
        Set<Dish> expected = dishes.stream().filter(d -> !d.isSweetDish() &&
                d.getIngredients().equals(Set.of(anyIngredientName))).collect(Collectors.toSet());
        when(dishRepository.findSavoryByIngredientNamesIn(Set.of(anyIngredientName))).thenReturn(expected);
        assertEquals(expected, dishService.findSavoryByIngredientNamesIn(Set.of(anyIngredientName)));
    }
}