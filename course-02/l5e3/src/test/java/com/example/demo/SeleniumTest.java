package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SeleniumTest {
    @Test
    public static void main(String[] args) throws InterruptedException {
        // set upt Web Driver Manager:
        WebDriverManager.chromedriver().setup();
        // set up Chrome driver:
        WebDriver driver = new ChromeDriver();
        // navigate to /animal page:
        driver.get("http://localhost:8080/animal");
        // select <input> with id="animalText":
        WebElement inputField = driver.findElement(By.id("animalText"));
        // type "goat" to this <input>:
        inputField.sendKeys("goat");

        // select <input> with id="adjective":
        inputField = driver.findElement(By.id("adjective"));
        // type "fucking" to this <input>:
        inputField.sendKeys("fucking");


        // define the list of results:
        List<WebElement> results = driver.findElements(By.className("trainingMessage"));

        // iterate over 5 (times), to hit submit button:
        for (int i = 0; i < 5; i++) {
            inputField = driver.findElement(By.id("adjective"));
            inputField.submit();
        }

        // print out results' size:
        System.out.println("Results: " + results.size());

        // define conclusion message:
        WebElement conclusion = driver.findElement(By.className("conclusionMessage"));
        System.out.println("Conclusion message: " + conclusion.getText());

        // quit Selenium test:
        Thread.sleep(5000);
        driver.quit();
    }
}
