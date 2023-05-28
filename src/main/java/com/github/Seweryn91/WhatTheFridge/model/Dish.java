package com.github.Seweryn91.WhatTheFridge.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Dish")
public class Dish implements Serializable, Comparable<Dish> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="sweetdish")
    private boolean sweetDish;
    @ManyToMany
    @JoinTable(
            name = "dish_ingredient",
            joinColumns = { @JoinColumn(name = "fk_dish_id")},
            inverseJoinColumns = { @JoinColumn(name = "fk_ingredient_id")} )
    private Set<Ingredient> ingredients = new HashSet<>();

    @Column(name="picturelink")
    private String pictureLink;

    @Column(name="recipelink")
    private String recipeLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public boolean isSweetDish() {
        return sweetDish;
    }

    public Set<Ingredient> getIngredients() { return ingredients; }

    public String getPictureLink() {
        return pictureLink;
    }

    public String getRecipeLink() {
        return recipeLink;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSweetDish(boolean sweetDish) {
        this.sweetDish = sweetDish;
    }

    public void setIngredients(Set<Ingredient> ingredients) { this.ingredients = ingredients; }

    public void setPictureLink(String pictureLink) { this.pictureLink = pictureLink;
    }

    public void setRecipeLink(String recipeLink) {
        this.recipeLink = recipeLink;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
        ingredient.getDishes().remove(this);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Dish otherDish)) return false;
        return getName() != null ? getName().equals(otherDish.getName()) : otherDish.getName() == null;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name =" + name;
    }


    @Override
    public int compareTo(Dish d) {
        return this.getName().compareTo(d.getName());
    }
}
