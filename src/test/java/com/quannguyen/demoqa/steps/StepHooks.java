package com.quannguyen.demoqa.steps;

import com.quannguyen.demoqa.utils.PropertiesFileUtil;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class StepHooks {
    WebDriver driver;

    @BeforeAll
    public static void beforeAll() throws IOException {
        PropertiesFileUtil.readProperties(System.getProperty("env.properties"));
    }

    @Before
    public void beforeScenario(Scenario scenario) throws IOException {
        String browser = System.getProperty("browser");
        if (browser != null && !browser.isEmpty()) {
            PropertiesFileUtil.readProperties(System.setProperty("BROWSER_TYPE", browser));
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(System.getProperty("BASE_URL"));
    }

}
