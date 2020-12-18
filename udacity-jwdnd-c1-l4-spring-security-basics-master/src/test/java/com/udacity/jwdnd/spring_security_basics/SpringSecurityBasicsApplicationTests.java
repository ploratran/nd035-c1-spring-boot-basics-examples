package com.udacity.jwdnd.spring_security_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

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

}
