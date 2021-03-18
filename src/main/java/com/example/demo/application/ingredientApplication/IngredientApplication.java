package com.example.demo.application.ingredientApplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.ingredient.IngredientProjection;
import com.example.demo.dto.ingredientDTO.CreateIngredientDTO;
import com.example.demo.dto.ingredientDTO.IngredientDTO;

public interface IngredientApplication {
    public IngredientDTO add(CreateIngredientDTO dto);

    public IngredientDTO get(UUID id);

    public void update(UUID id, CreateIngredientDTO dto);

    public void delete(UUID id);

    public List<IngredientProjection> findAll(String name, int page, int size);
}
