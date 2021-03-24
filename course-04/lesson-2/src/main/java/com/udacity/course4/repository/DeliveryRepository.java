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

    // save a new delivery:
    public void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    // return an existing delivery:
    public Delivery find(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    // return the newly updated delivery:
    public Delivery merge(Delivery delivery) {
        return entityManager.merge(delivery);
    }

    public void delete(Long id) {
        // find a delivery to be deleted by its id:
        Delivery delivery = entityManager.find(Delivery.class, id);
        // delete it:
        entityManager.remove(delivery);
    }
}
