package com.udacity.course4.service;

import com.udacity.course4.entity.Delivery;
import com.udacity.course4.projection.RecipientAndPrice;
import com.udacity.course4.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public RecipientAndPrice getBill(Long deliveryId){
        return deliveryRepository.getBill(deliveryId);
    }

    public Long save(Delivery delivery) {
        // Relationship of Delivery to Plants is 1:M
        // iterate through each plant in a delivery
        // set delivery for each plant:
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        // save delivery:
        deliveryRepository.persist(delivery);
        // return the saved delivery's id:
        return delivery.getId();
    }
}

