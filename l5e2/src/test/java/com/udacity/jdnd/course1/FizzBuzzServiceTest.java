package com.udacity.jdnd.course1;

import com.udacity.jdnd.course1.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzServiceTest {

	@Test
	void testBuzzFizz() {
		FizzBuzzService fbs = new FizzBuzzService();

		// check when input is non divisible to 3 and 5:
		assertEquals(2, fbs.buzzFizz("2", 1));
		assertEquals(23, fbs.buzzFizz("23", 1));

		// check when input is "Fizz":
		assertEquals(6, fbs.buzzFizz("Fizz", 2));
		assertEquals(12, fbs.buzzFizz("Fizz", 4));

		// check when input is "Buzz":
		assertEquals(5, fbs.buzzFizz("Buzz", 1));
		assertEquals(20, fbs.buzzFizz("Buzz", 4));

		// check when input is "FizzBuzz":
		assertEquals(15, fbs.buzzFizz("FizzBuzz", 1));
		assertEquals(30, fbs.buzzFizz("FizzBuzz", 2));
	}

	@Test
	void testFizzBuzz(){
		FizzBuzzService fbs = new FizzBuzzService();

		// check non-divisible numbers return themselves
		assertEquals("1", fbs.fizzBuzz(1));
		assertEquals("47", fbs.fizzBuzz(47));
		assertEquals("121", fbs.fizzBuzz(121));

		// check numbers divisible by 3
		assertEquals("Fizz", fbs.fizzBuzz(3));
		assertEquals("Fizz", fbs.fizzBuzz(333));

		//check numbers divisible by 5
		assertEquals("Buzz", fbs.fizzBuzz(5));
		assertEquals("Buzz", fbs.fizzBuzz(85));

		//check numbers divisible by 3 and 5
		assertEquals("FizzBuzz", fbs.fizzBuzz(15));
		assertEquals("FizzBuzz", fbs.fizzBuzz(75));

		//check invalid inputs
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(0));
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(-1));
	}
}
