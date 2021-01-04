package com.udacity.jwdnd.c1.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumExample {

    public static void main(String[] args) throws InterruptedException {
        // tell Web Driver manager to have Chrome driver set up:
        // check to see the version of Chrome and download WebDriver instance:
        WebDriverManager.chromedriver().setup();
        // set up Chrome from Selenium. WebDriver derives WebDriverManager:
        WebDriver driver = new ChromeDriver();
        // tell WebDriver to navigate to Google Search page:
        driver.get("http://www.google.com");
        // argument expects "By" to determine how driver searches for a Web Element on a page:
        WebElement inputField = driver.findElement(By.name("q"));
        // search for the search term "selenium" in the <input> element:
        inputField.sendKeys("selenium");
        // submit search button, then a list of results will display:
        inputField.submit();
        // print out result from search "selenium" on Google Search:
        // use "By" to use CSS selector to tell how driver search for <div>, class "g" <a> Web element
        // select a groupd of elements using By.cssSelector:
        List<WebElement> results = driver.findElements(By.cssSelector("div.g a"));
        // iterate over each result:
        for (WebElement element : results) {
            // use getAttribute() to get "href" attribute to each link:
            // thisi is the actual URL link is pointing to:
            String link = element.getAttribute("href");
            // print out each link:
            System.out.println(link);
        }
        Thread.sleep(5000);
        // shut down the driver:
        // if we dont call quit(), automated browser window will never close on its own:
        driver.quit();
    }

}
