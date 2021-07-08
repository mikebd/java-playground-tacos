package com.mikebd.playground.tacos.model;

import lombok.Data;

import java.util.List;

@Data
public class Taco {

    private String tacoName;
    private List<Ingredient> ingredients;
}