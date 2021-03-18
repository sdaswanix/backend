package com.example.demo.domain.ingredient;

import java.util.UUID;

import com.example.demo.dto.ingredientDTO.CreateIngredientDTO;
import com.example.demo.dto.ingredientDTO.IngredientDTO;

public class IngredientService {
    public static Ingredient create(CreateIngredientDTO dto) {
        Ingredient ingredient = new Ingredient();
        ingredient.name = dto.name;
        ingredient.price = dto.price;
        ingredient.id = UUID.randomUUID();
        return ingredient;
    }

    public static IngredientDTO createDTO(Ingredient ingredient) {
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.name = ingredient.name;
        ingredientDTO.id = ingredient.id;
        ingredientDTO.price = ingredient.price;
        return ingredientDTO;

    }

}
