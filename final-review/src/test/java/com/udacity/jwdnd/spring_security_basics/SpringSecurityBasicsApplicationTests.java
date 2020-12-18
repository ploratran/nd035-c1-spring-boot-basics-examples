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

// make sure the server is running before the tests start:
// tells JUnit to run the app before any tests are executed,
// with RANDOM_PORT number belongs to server port:
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
    // set up Selenium driver:
    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // after all tests, Selenium quit driver:
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
        signupPg = new SignupPage(driver);
        signupPg.signup(firstName, lastName, username, password);

        // navigate to /login:
        driver.get(baseURL + "/login");
        loginPg = new LoginPage(driver);
        loginPg.login(username, password);

        // after login success, auto navigate to /chat
        // no need to use driver.get(/chat):
        chatPg = new ChatPage(driver);
        chatPg.submitMessage(message);

        // use ChatMessage class in View to get message:
        ChatMessage result = chatPg.getMessage();

        // use JUnit to test if result match:
        assertEquals(username, result.getUsername());
        assertEquals(message, result.getMessageText());
    }
}
