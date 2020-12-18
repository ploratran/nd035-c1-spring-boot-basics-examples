package com.udacity.jwdnd.spring_security_basics;

import com.udacity.jwdnd.spring_security_basics.model.ChatMessage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

// define Spring Boot test with random port:
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringSecurityBasicsApplicationTests {

    // Spring annotation to let Selenium know which random port is used:
    // Spring will inject the current port into field annotation:
    @LocalServerPort
    private Integer port; // this port is the RANDOM_PORT

    // initialize driver:
    private static WebDriver driver;

    // initialize each Page Object instances:
    private LoginPage loginPg;
    private SignupPage signupPg;
    private ChatPage chatPg;

    // before all tests, setup Chrome as Web Driver:
    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // after all tests, quite driver:
    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    String baseURL;

    // before each test, navigate to localhost:${port}
    @BeforeEach
    public void beforeEach() {
        baseURL = "http://localhost:" + port;
    }

    @Test
    public void testSignUp() {
        // defined information to signup:
        String firstName = "Phuong";
        String lastName = "Tran";
        String username = "mimimama";
        String password = "mimimama";
        String message = "Hello World";

        // navigate to /signup:
        driver.get(baseURL + "/signup");

        // call .signup() on SignupPage to submit information:
        SignupPage signupPage = new SignupPage(driver);
        signupPage.signup(firstName, lastName, username, password);

        // navigate to /login:
        driver.get(baseURL + "/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // after login success, auto navigate to /chat
        // no need to use driver.get(/chat):
        ChatPage chatPage = new ChatPage(driver);
        chatPage.submitMessage(message);

        // use ChatMessage class in View to get message:
        ChatMessage result = chatPage.getMessage();

        // use JUnit to test if result match:
        assertEquals(username, result.getUsername());
        assertEquals(message, result.getMessageText());
    }
}
