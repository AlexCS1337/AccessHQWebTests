package com.assesshq.web.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Planet {
    private final WebDriver driver;
    private String planetName;

    public Planet(WebDriver driver) {
        this.driver = driver;
    }

    public String getName() {
        planetName = driver.findElement(By.className("name")).getText();
        return planetName;
    }

    public void clickExplore() {
        driver.findElement(By.className("button")).click();
    }
}
