package com.udacity.course4.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.course4.controller.Views;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

// Parent class called Plant that contains the shared attributes of name, price, and id:
// Using our table ‘plant’ to store all the shared data
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Plant {

    @Id
    @GeneratedValue
    private Long id;

    /** 2 fields: "name" and "price" are selected: */
    @JsonView(Views.Public.class)
    @Nationalized // similar to UTF-8
    private String name;

    @JsonView(Views.Public.class)
    @Column(precision=12, scale=4)
    private BigDecimal price;

    /**
     * Establish a bidirectional relationship between Delivery and
     * store it in the "plant" table in a column called "delivery_id"
     * */
    // use FetchType.LAZY so that plant won't query Delivery objects until they're referenced:
    @ManyToOne(fetch = FetchType.LAZY) // many plants can belong to one delivery
    @JoinColumn(name="delivery_id") // map the join column in the plant table (foreign key)
    private Delivery delivery;

    public Plant() {}

    public Plant(String name, double price) {
        this.name = name;
        this.price = BigDecimal.valueOf(price);
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
