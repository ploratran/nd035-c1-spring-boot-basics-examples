package com.udacity.course4.data;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

// Named Query that returns a list of all Deliveries for a specified name:
// It should accept a String name and return a list of Delivery Entities:
@NamedQuery(
        name = "Delivery.findAllDeliveries",
        query = "select d from Delivery d where d.name = :name"
)

// A Delivery you will make
@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @Nationalized // similar to UTF-8
    private String name;

    @Column(name="address_full", length=500)
    private String address;

    private LocalDateTime deliveryDate; // type LocalDateTime includes both date and time

    @Type(type="yes_no")
    private Boolean isDelivered;

    /**
     * Modify Delivery so that it includes a list of all the Flowers and Shrubs
     * to be included in the delivery. Make this association bidirectional,
     * and store the association in the ‘plant’ table in a column called ‘delivery_id’.
     * */
    // use "mappedBy" on the containing Entity side, usually for @OneToMany
    // use "CascadeType.REMOVE" to delete any associated Plants when removed:
    @OneToMany(mappedBy="delivery", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Plant> plants;

    public Delivery() {}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(Boolean delivered) {
        isDelivered = delivered;
    }

    public List<Plant> getPlants() {
        return (List<Plant>) new Plant();
    }
}
