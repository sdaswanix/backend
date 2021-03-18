package com.example.demo.domain.pizza;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.example.demo.domain.Comment.Comment;
import com.example.demo.domain.Image.Image;
import com.example.demo.domain.ingredient.Ingredient;

import org.hibernate.annotations.Type;

@Entity
public class Pizza {
    @Id
    @Type(type = "uuid-char")
    public UUID id;

    @Column(nullable = false, unique = true)
    public String name;

    private Double price;

    public void setPrice(Double value) {
        this.price = value;
    }

    @Column(nullable = false, name = "price")
    public Double getPrice() {
        return price;
    }

    public Double calculatePrice() {
        Double total = 0.0;
        for (Ingredient ingredient : this.ingredients) {
            total += ingredient.price;
        }
        return total = 5 + total * 1.20;
    }

    @ManyToMany
    private Set<Ingredient> ingredients = new HashSet<Ingredient>();

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pizza_id")
    Set<Comment> comments = new HashSet<Comment>();

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Embedded
    public Image image;

}
