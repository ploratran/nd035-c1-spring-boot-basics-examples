package com.udacity.jdnd.course1.service;

public class FizzBuzzService {

    /**
     * If number is divisible by 3, return "Fizz". If divisible by 5,
     * return "Buzz", and if divisible by both, return "FizzBuzz". Otherwise,
     * return the number itself.
     *
     * @Throws IllegalArgumentException for values < 1
     */
    public String fizzBuzz(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Value must be greater than 0");
            }
            // check if number is divisible by 15, return fizzbuzz:
            else if (i % 15 == 0) {
                return "FizzBuzz";
            }
            else if (i % 3 == 0) {
                return "Fizz";
            }
            else if (i % 5 == 0) {
                return "Buzz";
            }
            else {
                return "" + i;
            }
    }
}
