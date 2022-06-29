package com.assesshq.web.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PlanetPage {

    private final WebDriver driver;

    public PlanetPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getPopupMessage() {
        return driver.findElement(By.className("popup-message"));
    }

    public void clickExplore(String planetName) {
        for (Planet planet : getPlanets()
             ) {
            if (planet.getName().equalsIgnoreCase(planetName)) {
                planet.clickExplore();
                waitForPopupMessage();
                break;
            }
        }
    }

    private void waitForPopupMessage() {
        var popupElement = getPopupMessage();
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(popupElement));
    }


    public String getPopupText() {
        return getPopupMessage().getText();
    }

    public List<Planet> getPlanets() {
        var planets = new ArrayList<Planet>();
        for (WebElement planetElement : driver.findElements(By.className("planet"))) {
            planets.add(new Planet(planetElement));
        }
        return planets;
    }

}
