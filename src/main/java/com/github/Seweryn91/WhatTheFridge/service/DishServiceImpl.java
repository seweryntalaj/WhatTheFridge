package com.github.Seweryn91.WhatTheFridge.service;

import com.github.Seweryn91.WhatTheFridge.model.Dish;
import com.github.Seweryn91.WhatTheFridge.model.Ingredient;
import com.github.Seweryn91.WhatTheFridge.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private void setDishRepository(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Transactional
    public List<Dish> getDishList() {
        return dishRepository.findAll();
    }

    @Override
    public Set<Ingredient> getIngredients(long dishId) {
        return dishRepository.findById(dishId).get().getIngredients();
    }

    @Transactional
    public Dish findDishById(long id) {
        Optional<Dish> optional = dishRepository.findById(id);
        Dish dish = null;
        if (optional.isPresent()) dish = optional.get();
        else throw new RuntimeException("Dish not found for id :" + id);
        return dish;
    }

    @Override
    @Transactional
    public void delete(Dish dish) {
        dishRepository.delete(dish);
    }

    @Override
    @Transactional
    public Dish saveOrUpdate(Dish dish) {
        if (dish.getId() == null) return dishRepository.save(dish);
        else {
            Optional<Dish> dishOptional = dishRepository.findById(dish.getId());
            if (dishOptional.isPresent()) {
                Dish dish1 = dishOptional.get();
                dish1.setId(dish.getId());
                dish1.setName(dish.getName());
                dish1.setSweetDish(dish.isSweetDish());
                dish1.setIngredients(dish.getIngredients());
                dish1.setPictureLink(dish.getPictureLink());
                dish1.setRecipeLink(dish.getRecipeLink());
                dish1 = dishRepository.save(dish1);
                return dish1;
            }
            else {
                dishRepository.save(dish);
                return dish;
            }
        }
    }

    @Override
    @Transactional
    public Dish findByName(String name) {
        return dishRepository.findByName(name);
    }

    @Override
    @Transactional
    public List<Dish> findSweetByIngredientNamesIn(Set<String> ingredientsNames) {
        return dishRepository.findSweetByIngredientNamesIn(ingredientsNames);
    }

    @Override
    @Transactional
    public List<Dish> findSavoryByIngredientNamesIn(Set<String> ingredientNames) {
        return dishRepository.findSavoryByIngredientNamesIn(ingredientNames);
    }

    @Override
    public Page<Dish> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.dishRepository.findAll(pageable);
    }

    @Override
    public List<Dish> findByIngredientNamesIn(Set<String> ingredientNames) {
        return dishRepository.findByIngredientNamesIn(ingredientNames);
    }
}
