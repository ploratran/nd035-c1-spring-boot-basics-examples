package com.udacity.course4.repository;

import com.udacity.course4.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    // 1. Save a new Plant and return its Id:
    // use the default .save() of JpaRepository so no need to implement

    // 2. Check if a plant has been delivered
    // should take a Long plantId and return a Boolean:
    @Query("select p.delivery.isDelivered from Plant p where p.id = :plantId")
    Boolean deliveryCompleted(Long plantId);

    // 3. Find a list of plants cheaper than a specified amount
    // should take a BigDecimal price and return a List of Plants:
    // can use method name with LessThan
    // Reference: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
    List<Plant> findByPriceLessThan(BigDecimal price);
}
