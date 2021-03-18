package com.example.demo.domain.pizza;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface PizzaDetail {
    public UUID getId();

    public String getName();

    public Double getPrice();

    public Image getImage();

    public interface Image {
        public String getPublic_id();
    }

    public List<PizzaDetailIngredients> getIngredients();

    public List<PizzaDetailComments> getComments();

    public interface PizzaDetailIngredients {
        public UUID getId();

        public String getName();

    }

    public interface PizzaDetailComments {
        public UUID getId();

        public String getText();

        public Date getDate();

        public Integer getRating();
    }
}
