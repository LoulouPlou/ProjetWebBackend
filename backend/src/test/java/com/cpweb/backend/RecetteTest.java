package com.cpweb.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecetteTest {
    private WebDriver driverF = new FirefoxDriver();
    private WebDriver driverC = new ChromeDriver();

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","./data/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver","./data/chromedriver.exe");
    }

    @Test
    public void testAddRecetteSansLoginFirefox(){
        driverF.get("http://localhost:2267/AddRecipe");

        // assert
        assertEquals(driverF.getCurrentUrl(), "http://localhost:2267/Connexion");
    }

    @Test
    public void testAddRecetteSansLoginChrome(){
        driverC.get("http://localhost:2267/AddRecipe");

        // assert
        assertEquals(driverC.getCurrentUrl(), "http://localhost:2267/Connexion");
    }
}
