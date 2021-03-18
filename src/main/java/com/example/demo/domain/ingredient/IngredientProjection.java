package com.example.demo.domain.ingredient;

import java.util.UUID;

public interface IngredientProjection {
    public UUID getId();

    public String getName();

    public Double getPrice();

}
