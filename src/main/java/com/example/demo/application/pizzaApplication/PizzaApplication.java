package com.example.demo.application.pizzaApplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.pizza.PizzaDetail;
import com.example.demo.domain.pizza.PizzaProjection;
import com.example.demo.dto.CommentDTO.CommentDTO;
import com.example.demo.dto.CommentDTO.CreateCommentDTO;
import com.example.demo.dto.pizzaDTO.CreatePizzaDTO;
import com.example.demo.dto.pizzaDTO.PizzaDTO;

public interface PizzaApplication {
    public PizzaDTO add(CreatePizzaDTO pizzaDTO);

    public PizzaDTO get(UUID id);

    public void update(UUID id, CreatePizzaDTO pizzaDTO);

    public void delete(UUID id);

    public void deleteIngredient(UUID pizzaId, UUID ingredientId);

    public void addIngredient(UUID pizzaId, UUID ingredientId);

    public CommentDTO addComment(UUID pizzaId, CreateCommentDTO commentDTO);

    public List<PizzaProjection> findAll(String name, int page, int size);

    public PizzaDetail findDetail(UUID id);
}
