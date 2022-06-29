package com.assesshq.web.tests;

import com.assesshq.web.model.PlanetPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void Verify_Earth_Prompt() {
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();

        var planetPage = new PlanetPage(driver);
        planetPage.clickExplore("Earth");
        Assertions.assertEquals("Exploring Earth", planetPage.getPopupText());
    }

    @AfterEach
    public void tearDown () {
        driver.quit();
    }
}
