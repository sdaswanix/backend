package com.example.demo.application.pizzaApplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.Comment.Comment;
import com.example.demo.domain.Comment.CommentService;
import com.example.demo.domain.ingredient.Ingredient;
import com.example.demo.domain.ingredient.IngredientRepository;
import com.example.demo.domain.pizza.Pizza;
import com.example.demo.domain.pizza.PizzaDetail;
import com.example.demo.domain.pizza.PizzaProjection;
import com.example.demo.domain.pizza.PizzaRepository;
import com.example.demo.domain.pizza.PizzaService;
import com.example.demo.dto.CommentDTO.CommentDTO;
import com.example.demo.dto.CommentDTO.CreateCommentDTO;
import com.example.demo.dto.pizzaDTO.CreatePizzaDTO;
import com.example.demo.dto.pizzaDTO.PizzaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaApplicationImp implements PizzaApplication {

    private final PizzaRepository pizzaRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public PizzaApplicationImp(final PizzaRepository pizzaRepository, final IngredientRepository ingredientRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public PizzaDTO add(CreatePizzaDTO pizzaDTO) {
        Pizza pizza = PizzaService.create(pizzaDTO);
        for (UUID ingredientID : pizzaDTO.ingredients) {
            Ingredient ingredient = this.ingredientRepository.findById(ingredientID).orElseThrow();
            pizza.addIngredient(ingredient);
        }
        Double price = pizza.calculatePrice();
        pizza.setPrice(price);
        this.pizzaRepository.add(pizza);
        return PizzaService.createDTO(pizza);
    }

    @Override
    public PizzaDTO get(UUID id) {
        Pizza pizza = this.pizzaRepository.findById(id).orElseThrow();
        return PizzaService.createDTO(pizza);
    }

    @Override
    public void update(UUID id, CreatePizzaDTO pizzaDTO) {
        Pizza pizza = this.pizzaRepository.findById(id).orElseThrow();
        pizza.name = pizzaDTO.name;
        for (UUID ingredientId : pizzaDTO.ingredients) {
            Ingredient ingredient = this.ingredientRepository.findById(ingredientId).orElseThrow();
            pizza.addIngredient(ingredient);
        }
        this.pizzaRepository.update(pizza);
    }

    @Override
    public void delete(UUID id) {
        Pizza pizza = this.pizzaRepository.findById(id).orElseThrow();
        this.pizzaRepository.delete(pizza);

    }

    @Override
    public void deleteIngredient(UUID pizzaId, UUID ingredientId) {
        Ingredient ingredient = this.ingredientRepository.findById(ingredientId).orElseThrow();
        Pizza pizza = this.pizzaRepository.findById(pizzaId).orElseThrow();
        pizza.removeIngredient(ingredient);
        Double price = pizza.calculatePrice();
        pizza.setPrice(price);
        this.pizzaRepository.add(pizza);
    }

    @Override
    public void addIngredient(UUID pizzaId, UUID ingredientId) {
        Ingredient ingredient = this.ingredientRepository.findById(ingredientId).orElseThrow();
        Pizza pizza = this.pizzaRepository.findById(pizzaId).orElseThrow();
        pizza.addIngredient(ingredient);
        Double price = pizza.calculatePrice();
        pizza.setPrice(price);
        this.pizzaRepository.add(pizza);

    }

    @Override
    public CommentDTO addComment(UUID pizzaId, CreateCommentDTO commentDTO) {
        Pizza pizza = this.pizzaRepository.findById(pizzaId).orElseThrow();
        Comment comment = CommentService.create(commentDTO);
        pizza.addComment(comment);
        this.pizzaRepository.add(pizza);
        return CommentService.createDTO(comment);
    }

    @Override
    public List<PizzaProjection> findAll(String name, int page, int size) {
        return this.pizzaRepository.findAll(name, page, size);
    }

    @Override
    public PizzaDetail findDetail(UUID id) {
        return this.pizzaRepository.findDetail(id);
    }

}
