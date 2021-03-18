package com.example.demo.infraestructure.ingredientRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.ingredient.Ingredient;
import com.example.demo.domain.ingredient.IngredientProjection;
import com.example.demo.domain.ingredient.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientRepositoryImp implements IngredientRepository {

    private final IngredientJPARepository ingredientJPARepository;// Relaciona la interfaz del JPA

    @Autowired
    public IngredientRepositoryImp(final IngredientJPARepository ingredientJPARepository) {
        this.ingredientJPARepository = ingredientJPARepository;
    }

    // Se implementa los metodos definidos en la interfaz
    public void add(Ingredient ingredient) {
        this.ingredientJPARepository.save(ingredient);
    }

    public void update(Ingredient ingredient) {
        this.ingredientJPARepository.save(ingredient);
    }

    @Override
    public void delete(Ingredient ingredient) {
        this.ingredientJPARepository.delete(ingredient);

    }

    @Override
    public Optional<Ingredient> findById(UUID id) {
        return this.ingredientJPARepository.findById(id);
    }

    @Override
    public List<IngredientProjection> findAll(String name, int page, int size) {
        return this.ingredientJPARepository.findByCriteria(name,
                PageRequest.of(page, size, Sort.by("name").descending()));
    }

}
