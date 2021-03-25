package com.udacity.course4.projection;

import java.math.BigDecimal;

// this is a Projection class since it's not an Entity class
public class RecipientAndPrice {
    private String name;
    private BigDecimal price;

    public RecipientAndPrice(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
