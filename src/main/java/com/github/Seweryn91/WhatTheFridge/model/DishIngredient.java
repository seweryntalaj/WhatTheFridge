package com.github.Seweryn91.WhatTheFridge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dish_ingredient")
public class DishIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Dish dish;

    @ManyToOne
    private Ingredient ingredient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dish getDish() { return dish; }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

}
