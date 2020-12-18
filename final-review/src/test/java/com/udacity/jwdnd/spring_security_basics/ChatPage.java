package com.udacity.jwdnd.spring_security_basics;

import com.udacity.jwdnd.spring_security_basics.model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

// Page Object for chat.html:
public class ChatPage {
    // define fields:
    @FindBy(id="newMessageText")
    private WebElement messageText;

    @FindBy(id = "messageType")
    private WebElement messageType;

    @FindBy(id = "submitMessage")
    private WebElement submitBtn;

    @FindBy(className="chatMessageUsername")
    private WebElement chatUsername;

    @FindBy(className = "chatMessageText")
    private WebElement chatText;

    // declare constructor with WebDriver as constructor argument:
    // helps to whenever we create new ChatPage object, Selenium will automatically
    // find and capture elements we declare:
    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // define helper functions to fill information:
    public void submitMessage(String message) {
        // fill in information:
        this.messageText.sendKeys(message);
        // click submit:
        this.submitBtn.click();
    }

    // define helper function to display result:
    public ChatMessage getMessage() {
        // use ChatMessage class from View:
        ChatMessage result = new ChatMessage();
        // use .getText() to get text from browser
        // use .setMessageText() from ChatMessage class
        // to set text:
        result.setMessageText(this.chatText.getText());
        // use .getText() to get text from browser
        // use .setUsername() from ChatMessage class
        // to set username:
        result.setUsername(this.chatUsername.getText());
        // return result to display chat result to screen:
        return result;
    }
}
