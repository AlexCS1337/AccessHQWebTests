package com.assesshq.web.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;

public class Planet {
    private final WebElement planetElement;
    private String planetName;

    public Planet(WebElement planetElement) {
        this.planetElement = planetElement;
    }

    public String getName() {
        return planetElement.findElement(By.className("name")).getText();
    }

    public void clickExplore() {
        planetElement.findElement(By.tagName("button")).click();
    }

    public double getRadius() throws ParseException {
        var radiusText = planetElement.findElement(By.className("radius")).getText();
        double radius = NumberFormat.getNumberInstance().parse(radiusText).doubleValue();
        return radius;
    }
}
