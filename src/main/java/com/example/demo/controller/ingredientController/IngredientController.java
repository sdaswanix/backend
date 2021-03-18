package com.example.demo.controller.ingredientController;

import java.util.UUID;

import com.example.demo.application.ingredientApplication.IngredientApplication;
import com.example.demo.dto.ingredientDTO.CreateIngredientDTO;
import com.example.demo.dto.ingredientDTO.IngredientDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/v1/ingredients")
public class IngredientController {
    private final IngredientApplication ingredientApplication;

    @Autowired
    public IngredientController(final IngredientApplication ingredientApplication) {
        this.ingredientApplication = ingredientApplication;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> create(@RequestBody final CreateIngredientDTO dto) {
        IngredientDTO ingredient = this.ingredientApplication.add(dto);
        return ResponseEntity.status(201).body(ingredient);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> get(@PathVariable UUID id) {
        IngredientDTO ingredient = this.ingredientApplication.get(id);
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public @ResponseBody ResponseEntity<?> update(@PathVariable UUID id, @RequestBody CreateIngredientDTO dto) {
        this.ingredientApplication.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable UUID id) {
        this.ingredientApplication.delete(id);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.ingredientApplication.findAll(name, page, size));
    }
}
