package com.assesshq.web.model;

import com.assesshq.web.strategies.MatchingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Predicate;

public class PlanetPage {

    private final WebDriver driver;

    public PlanetPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getPopupMessage() {
        return driver.findElement(By.className("popup-message"));
    }

    public void clickExplore(Planet planet) {
        planet.clickExplore();
        waitForPopupMessage();
    }

    private void waitForPopupMessage() {
        var popupElement = getPopupMessage();
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(popupElement));
    }


    public String getPopupText() {
        return getPopupMessage().getText();
    }

    public Planet getPlanet(Predicate<Planet> testLogic) {
        for (WebElement planetElement : driver.findElements(By.className("planet"))) {
            var planet = new Planet(planetElement);
            if (testLogic.test(planet)) {
                return planet;
            }
        }
        throw new NotFoundException("Could not find planet");
    }

}
