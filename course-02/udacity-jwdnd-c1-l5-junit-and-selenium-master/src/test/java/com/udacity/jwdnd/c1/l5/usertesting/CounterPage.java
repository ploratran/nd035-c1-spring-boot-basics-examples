package com.udacity.jwdnd.c1.l5.usertesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CounterPage {

    // define fields, query elements by id using Page Object:
    @FindBy(id = "count-display")
    private WebElement countDisplay;

    @FindBy(id = "increment-button")
    private WebElement incrementButton;

    @FindBy(id = "reset-value-field")
    private WebElement resetValueField;

    @FindBy(id = "reset-button")
    private WebElement resetButton;

    // declare constructor with WebDriver as constructor argument:
    // helps to whenever we create new CounterPage object, Selenium will automatically
    // find and capture elements we declare:
    public CounterPage(WebDriver driver) {
        // tell Selenium to use the given driver to initialize the @FindBy-annotated fields in the class:
        PageFactory.initElements(driver, this);
    }


    // define helper methods:

    public int getDisplayedCount() {
        // read current count from screen:
        return Integer.parseInt(countDisplay.getText());
    }

    public void incrementCount() {
        // click button to increment the count:
        incrementButton.click();
    }

    public void resetCount(int value) {
        // clear field:
        resetValueField.clear();
        // input new value as String:
        resetValueField.sendKeys(String.valueOf(value));
        // click button to reset:
        resetButton.click();
    }
}
