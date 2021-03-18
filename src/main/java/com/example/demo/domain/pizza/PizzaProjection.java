package com.example.demo.domain.pizza;

import java.util.UUID;

public interface PizzaProjection {
    public UUID getId();

    public String getName();

    public Double getPrice();

    public Image getImage();

    public interface Image {
        public String getPublic_id();
    }
}
