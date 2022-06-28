package com.assesshq.web;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormsPlaygroundSuite {
    private ChromeDriver driver;

    @BeforeEach
    public void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/forms");
    }

    @Test
    public void Verify_Form_Submit() throws InterruptedException {
        //driver.findElementByCssSelector("[")
        driver.findElementById("name").sendKeys("Blah");
        driver.findElementById("email").sendKeys("Blah@blah.com");
        driver.findElementByCssSelector("[for=agree]").click();
        //driver.findElementByClassName("v-input--selection-controls__ripple").click();

        //driver.findElementByClassName("v-btn--is-elevated").click();
        /*for (WebElement currentElement : driver.findElementByTagName("button")) {
            if (currentElement.getText().equalsIgnoreCase("submit")) {
                //
            }
        }*/
        var popupElement = driver.findElementByClassName("popup-message");
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(popupElement));
        Assertions.assertEquals("Thanks for your feedback Blah", popupElement.getText());
    }

    @AfterEach
    public void tearDown () {
        driver.quit();
    }

}
