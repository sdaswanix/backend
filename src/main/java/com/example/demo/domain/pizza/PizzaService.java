package com.example.demo.domain.pizza;

import java.util.UUID;

import com.example.demo.domain.ingredient.Ingredient;
import com.example.demo.dto.pizzaDTO.CreatePizzaDTO;
import com.example.demo.dto.pizzaDTO.PizzaDTO;
import com.example.demo.dto.pizzaDTO.PizzaIngredientDTO;

public class PizzaService {
    public static Pizza create(CreatePizzaDTO pizzaDTO) {
        Pizza pizza = new Pizza();
        pizza.name = pizzaDTO.name;
        pizza.id = UUID.randomUUID();
        return pizza;
    }

    public static PizzaDTO createDTO(Pizza pizza) {
        PizzaDTO pizzaDTO = new PizzaDTO();
        pizzaDTO.id = pizza.id;
        pizzaDTO.name = pizza.name;
        pizzaDTO.price = pizza.getPrice();
        for (Ingredient ingredient : pizza.getIngredients()) {
            PizzaIngredientDTO pizzaIngredientDTO = new PizzaIngredientDTO();
            pizzaIngredientDTO.name = ingredient.name;
            pizzaIngredientDTO.id = ingredient.id;
            pizzaDTO.ingredients.add(pizzaIngredientDTO);
        }
        return pizzaDTO;
    }
}
