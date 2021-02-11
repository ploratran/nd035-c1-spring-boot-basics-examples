package com.udacity.course4.data;

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

    @Nationalized
    private String name;

    @Column(precision=12, scale=4)
    private BigDecimal price;

    /**
     * Establish a bidirectional relationship between Delivery and
     * store it in the "plant" table in a column called "delivery_id"
     * */
    @ManyToOne // many plants can belong to one delivery
    @JoinColumn(name="delivery_id") // map the join column in the plant table
    private Delivery delivery;

    public Plant() {}

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
}
