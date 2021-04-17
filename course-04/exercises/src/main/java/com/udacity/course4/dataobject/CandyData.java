package com.udacity.course4.dataobject;

// Data Object class for Candy table, without using JPA/Hibernate
// This class maps directly to the candy table.
// Have one field for each column in the candy table: id, name, price
public class CandyData {
    private Long id;

    /** Candy attributes */
    private String name;
    private Double price;

    public CandyData() {}

    public CandyData(String name, Double price) {
        this.name = name;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}