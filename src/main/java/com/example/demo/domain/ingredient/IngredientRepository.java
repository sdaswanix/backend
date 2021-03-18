package com.example.demo.domain.ingredient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IngredientRepository {
    public void add(Ingredient ingredient);

    public void update(Ingredient ingredient);

    public void delete(Ingredient ingredient);

    public Optional<Ingredient> findById(UUID id);

    public List<IngredientProjection> findAll(String name, int Page, int size);

}
