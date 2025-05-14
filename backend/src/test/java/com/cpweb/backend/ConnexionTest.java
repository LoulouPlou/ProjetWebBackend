package com.cpweb.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnexionTest {
    private WebDriver driver = new FirefoxDriver();
    private WebDriver driver2 = new ChromeDriver();

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "./data/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "./data/chromedriver.exe");
    }

    @Test
    public void testConnexionForm(){
        driver.get("http://localhost:2267/Connexion");

        WebElement courriel = driver.findElement(By.name("courriel"));
        WebElement motDePasse = driver.findElement(By.name("motDePasse"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        courriel.sendKeys("meow");
        motDePasse.sendKeys("meow123456789");
        loginButton.click();

        String connexionConfirmer = "http://localhost:2267";
        assertEquals(driver.getCurrentUrl(), connexionConfirmer);

    }
}
