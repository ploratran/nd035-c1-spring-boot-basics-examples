package com.udacity.course4;

import com.udacity.course4.entity.Delivery;
import com.udacity.course4.entity.Plant;
import com.udacity.course4.repository.PlantRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
class Course4ApplicationTests {

	// inject a TestEntityManager:
	@Autowired
	TestEntityManager manager;

	// test PlantRepository:
	@Autowired
	PlantRepository repository;

	// method to validates PlantRepository.findByPriceLessThan method:
	@Test
	public void testPriceLessThan() {
		// add 2 new plants to your database with different prices:
		Plant plant1 = manager.persist(new Plant("White Rose", 10.99));
		Plant plant2 = manager.persist(new Plant("Sunflower", 4.99)); // cheaper than $5 plant for testing

		// use PlantRepository.findByPriceLessThan() to make sure the correct plant is returned:
		List<Plant> cheapPlants = this.repository.findByPriceLessThan(BigDecimal.valueOf(5));

		// test if cheaperPlants id is the same with plant2's id:
		Assertions.assertEquals(plant2.getId(), cheapPlants.get(0).getId());
	}

	// method to validates PlantRepository.deliveryCompleted method:
	@Test
	public void testDeliveryCompleted() {
		// create a new Plant and new Delivery:
		Plant plant1 = manager.persist(new Plant("White Rose", 10.99));
		Delivery delivery1 = manager.persist(new Delivery("White Rose", "724 2ND LN", LocalDateTime.now(), true));

		Plant plant2 = manager.persist(new Plant("Forget Me Not", 15.99));
		Delivery delivery2 = manager.persist(new Delivery("Forget Me Not", "415 Delano Ave", LocalDateTime.now(), false));

		// set both sides of their bi-directional relationship:
		delivery1.setPlants(Lists.newArrayList(plant1));
		plant1.setDelivery(delivery1);

		delivery2.setPlants(Lists.newArrayList(plant2));
		plant2.setDelivery(delivery2);

		// verify that PlantRepository.deliveryCompleted returns false for the plant just created:
		Assertions.assertTrue(this.repository.deliveryCompleted(plant1.getId()));
		Assertions.assertFalse(this.repository.deliveryCompleted(plant2.getId()));
	}
}
