package com.example.demo.infraestructure.pizzaRepository;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.pizza.Pizza;
import com.example.demo.domain.pizza.PizzaDetail;
import com.example.demo.domain.pizza.PizzaProjection;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PizzaJPARepository extends JpaRepository<Pizza, UUID> {
    @Query("SELECT p.id as id, p.name as name, p.price as price, p.image as image FROM Pizza p WHERE :name IS NULL OR p.name LIKE %:name%")
    List<PizzaProjection> findByCriteria(@Param("name") String name, Pageable pageable);

    @Query("SELECT p FROM Pizza p JOIN FETCH p.ingredients LEFT JOIN FETCH p.comments WHERE p.id=:id")
    PizzaDetail findDetail(@Param("id") UUID id);
}
