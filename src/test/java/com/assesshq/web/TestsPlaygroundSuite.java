package com.assesshq.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestsPlaygroundSuite {

    @Test
    public void Verify_Message_Alert() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.findElementById("forename").sendKeys("Test123");
        driver.findElementById("submit").click();

        driver.quit();
    }
}
