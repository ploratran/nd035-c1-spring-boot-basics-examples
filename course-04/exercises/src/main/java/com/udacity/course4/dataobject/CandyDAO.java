package com.udacity.course4.dataobject;

import java.util.List;

// Define an interface for Candy DAO
// Add three method signatures:
public interface CandyDAO {
    // Get a list of all the available candy:
    List<CandyData> retrieveAllCandies();

    // A method that allows you to add a candy item by candyId to a delivery by id:
    void addCandyToDelivery(Long candyId, Long deliveryId);

    // A method that lets you get a list of all the candy for a specific delivery:
    List<CandyData> retrieveCandiesByDeliveryId(Long deliveryId);
}
