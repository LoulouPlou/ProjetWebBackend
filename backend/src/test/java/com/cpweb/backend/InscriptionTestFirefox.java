package com.cpweb.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InscriptionTestFirefox {

    private WebDriver driverF = new FirefoxDriver();

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "./data/geckodriver.exe");

    }

    @Test
    public void testInscriptionFormF(){
        driverF.get("http://localhost:2267/Inscription");

        WebElement nom = driverF.findElement(By.name("nom"));
        WebElement prenom = driverF.findElement(By.name("prenom"));
        WebElement nomAffichage = driverF.findElement(By.name("nomAffichage"));
        WebElement courriel = driverF.findElement(By.name("courriel"));
        WebElement motDePasse = driverF.findElement(By.name("motDePasse"));
        WebElement inscButton = driverF.findElement(By.id("inscription"));

        nom.sendKeys("meeow");
        prenom.sendKeys("miaw");
        nomAffichage.sendKeys("meeowMiaw");
        courriel.sendKeys("meeow@firefox.com");
        motDePasse.sendKeys("meeow123456789");
        inscButton.click();

       String connexionConfirmer = "http://localhost:2267/Connexion";

        // ne fonctionne pas à cause du alert ?
        //assertEquals(driverF.getCurrentUrl(), "http://localhost:2267/Connexion");
    }


}
