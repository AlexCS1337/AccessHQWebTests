package com.assesshq.web.tests;

import com.assesshq.web.model.PlanetPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;

public class TestsPlaygroundSuite {

    private ChromeDriver driver;

    @BeforeEach
    public void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }

    @Test
    public void Verify_Message_Alert() throws InterruptedException {
        driver.findElementById("forename").sendKeys("Test123");
        driver.findElementById("submit").click();

        var popupElement = driver.findElementByClassName("popup-message");
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(popupElement));
        Assertions.assertEquals("Hello Test123", popupElement.getText());
    }

    @Test
    public void Verify_Earth_Prompt() throws ParseException {
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();

        var planetPage = new PlanetPage(driver);
        //planetPage.clickExploreByName("Earth");
        planetPage.clickExplore(planet -> planet.getName().equalsIgnoreCase("Earth"));
        Assertions.assertEquals("Exploring Earth", planetPage.getPopupText());
    }

    @Test
    public void Verify_Saturn_Prompt() throws ParseException {
        // Arrange
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();

        // Act
        var planetPage = new PlanetPage(driver);
        planetPage.clickExplore(planet -> planet.getRadius() == 58232);
        //planetPage.clickExploreByRadius(58232);

        // Assert
        Assertions.assertEquals("Exploring Saturn", planetPage.getPopupText());
    }

    @AfterEach
    public void tearDown () {
        driver.quit();
    }
}
