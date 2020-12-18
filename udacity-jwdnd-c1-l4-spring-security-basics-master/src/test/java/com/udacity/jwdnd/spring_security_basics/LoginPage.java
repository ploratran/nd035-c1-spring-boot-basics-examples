package com.udacity.jwdnd.spring_security_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Page Object for login.html:
public class LoginPage {

    // define fields:
    @FindBy(id = "inputUsername")
    private WebElement username;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(id = "submit-button")
    private WebElement submitBtn;

    // define constructor:
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // define helper method to fill in information:
    public void login(String username, String password) {
        // use .sendKeys() to submit information:
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        // use .click() to submit button:
        this.submitBtn.click();
    }
}
