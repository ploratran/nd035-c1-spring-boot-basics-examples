package com.udacity.course4.data;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

// A Delivery you will make
@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
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
    @OneToMany(mappedBy="delivery")
    // @JoinColumn(name="delivery_id")
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
}
