package com.udacity.course4.repository;

import com.udacity.course4.data.Delivery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Class to create methods to
 * persist, find, merge and delete Delivery objects
 **/
public class DeliveryRepository {

    // define EntityManager:
    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    public Delivery find(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    public Delivery merge(Delivery delivery) {
        return entityManager.merge(delivery);
    }

    public void delete(Long id) {
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }
}
