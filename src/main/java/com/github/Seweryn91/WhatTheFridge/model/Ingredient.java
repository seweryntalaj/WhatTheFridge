package com.github.Seweryn91.WhatTheFridge.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Ingredient")
public class Ingredient implements Serializable, Comparable<Ingredient> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Dish> dishes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public int compareTo(Ingredient i) {
        int compare = getName().compareToIgnoreCase(i.getName());
        return compare == 0 ? getName().compareToIgnoreCase(i.getName()) : compare;
    }
}