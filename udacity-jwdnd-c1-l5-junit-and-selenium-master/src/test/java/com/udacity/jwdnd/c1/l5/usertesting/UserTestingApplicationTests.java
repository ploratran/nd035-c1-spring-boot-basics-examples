package com.udacity.jwdnd.c1.l5.usertesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

// make sure the server is running before the tests start:
// tells JUnit to run the app before any tests are executed,
// with RANDOM_PORT number belongs to server port:
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserTestingApplicationTests {

    // Spring annotation to let Selenium know which random port is used:
    // Spring will inject the current port into field annotation:
    @LocalServerPort
    private Integer port; // this port is the RANDOM_PORT

    private static WebDriver driver;
    private CounterPage counter;

    @BeforeAll
    public static void beforeAll() {
        // set up Selenium driver:
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void afterAll() {
        // quite Selenium driver:
        driver.quit();
    }

    @BeforeEach
    public void beforeEach() {
        // navigate to the /counter URL
        driver.get("http://localhost:" + port + "/counter");
        // initialize a new CounterPage object:
        // every test will start from URL with new CounterPage object:
        counter = new CounterPage(driver);
    }

    @Test
    public void testIncrement() {
        // define prevValue as current count displayed on screen:
        int prevValue = counter.getDisplayedCount();
        // click to increment count:
        counter.incrementCount();
        // test if prevValue + 1 equals current count value:
        assertEquals(prevValue + 1, counter.getDisplayedCount());
    }

    @Test
    public void testIncrementTenTimes() {
        // define prevValue as current count displayed on screen:
        int prevValue = counter.getDisplayedCount();
        // iterate over 10 times
        for (int i = 0; i < 10; i++) {
            // test if prevValue + 1 equals current counter value:
            assertEquals(prevValue + i, counter.getDisplayedCount());
            // increment counter:
            counter.incrementCount();
        }
    }

    @Test
    public void testReset() {
        // reset counter to 10:
        counter.resetCount(10);
        // test if current counter value equals 10:
        assertEquals(10, counter.getDisplayedCount());

        // reset counter to 0:
        counter.resetCount(0);
        // test if current counter value equals 0:
        assertEquals(0, counter.getDisplayedCount());
    }

}
