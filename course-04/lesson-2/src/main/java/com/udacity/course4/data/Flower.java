package com.udacity.course4.data;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

// A Flower for your company to sell
@Entity
@Table(name="plant")
public class Flower {

    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;
    private String color;
    @Column(precision=12, scale=4)
    private BigDecimal price;

    public Flower() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

