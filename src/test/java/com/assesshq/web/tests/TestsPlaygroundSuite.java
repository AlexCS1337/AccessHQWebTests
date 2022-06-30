package com.assesshq.web.tests;

import com.assesshq.web.model.Planet;
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
    public void Verify_Name_Explore() throws ParseException {
        //Arrange
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();

        //Act
        var planetPage = new PlanetPage(driver);
        planetPage.clickExplore(planetPage.getPlanet(p -> p.getName().equalsIgnoreCase("Earth")));

        //Assert
        Assertions.assertEquals("Exploring Earth", planetPage.getPopupText());
    }

    @Test
    public void Verify_Radius_Explore() throws ParseException {
        // Arrange
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();

        // Act
        var planetPage = new PlanetPage(driver);
        Planet planet = planetPage.getPlanet(p -> p.getRadius() == 58232);
        planetPage.clickExplore(planet);

        // Assert
        Assertions.assertEquals("Exploring Saturn", planetPage.getPopupText());
    }

    @Test
    public void Verify_Distance_Explore() {
        // Arrange
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();

        // Act
        var planetPage = new PlanetPage(driver);
        Planet planet = planetPage.getPlanet(p -> p.getDistance() == 778500000);
        planetPage.clickExplore(planet);

        // Assert
        Assertions.assertEquals("Exploring Jupiter", planetPage.getPopupText());
    }

    @Test
    public void Verify_Correct_Total() {
        // GIVEN I am on home page
        // WHEN I set <item> to <qty>
        // THEN <item> subtotal is $<subtotal>
        // AND the total is $<total>
    }

    @Test
    public void Verify_Correct_Multiple_Item_Price_Total() {
        // GIVEN I am on home page
        // WHEN I set Livi's Qty to 4
        // AND T-shirt's Qty tp 5
        // Then the total is $379.91
    }

    @AfterEach
    public void tearDown () {
        driver.quit();
    }
}
