package com.example.demo.application.ingredientApplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.ingredient.Ingredient;
import com.example.demo.domain.ingredient.IngredientProjection;
import com.example.demo.domain.ingredient.IngredientRepository;
import com.example.demo.domain.ingredient.IngredientService;
import com.example.demo.dto.ingredientDTO.CreateIngredientDTO;
import com.example.demo.dto.ingredientDTO.IngredientDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientApplicationImp implements IngredientApplication {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientApplicationImp(final IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientDTO add(CreateIngredientDTO dto) {
        // Input
        Ingredient ingredient = IngredientService.create(dto);
        this.ingredientRepository.add(ingredient);
        // Output
        return IngredientService.createDTO(ingredient);
    }

    @Override
    public void update(UUID id, CreateIngredientDTO dto) {
        Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
        ingredient.name = dto.name;
        ingredient.price = dto.price;
        this.ingredientRepository.update(ingredient);
    }

    @Override
    public IngredientDTO get(UUID id) {
        Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
        return IngredientService.createDTO(ingredient);
    }

    @Override
    public void delete(UUID id) {
        Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
        this.ingredientRepository.delete(ingredient);
    }

    @Override
    public List<IngredientProjection> findAll(String name, int page, int size) {

        return this.ingredientRepository.findAll(name, page, size);
    }

}
