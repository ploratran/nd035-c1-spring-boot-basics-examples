package com.udacity.jwdnd.spring_security_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Page Object for signup.html:
public class SignupPage {

    @FindBy(id = "inputFirstName")
    private WebElement firstName;

    @FindBy(id = "inputLastName")
    private WebElement lastName;

    @FindBy(id = "inputUsername")
    private WebElement username;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(id = "submit-button")
    private WebElement submitBtn;

    // constructor:
    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // define helper methods:
    // to sign up user information, then click submit:
    public void signup(String firstName, String lastName, String username, String password) {
        // use .sendKeys() to field in input field:
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        // use click to submit button:
        this.submitBtn.click();
    }
}
