package com.assesshq.web.tests;
import com.assesshq.web.model.Form;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormsPlaygroundSuite {
    private WebDriver driver;

    @BeforeEach
    public void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }

    @Test
    public void Verify_Form_Submit() throws InterruptedException {
        // Arrange
        driver.findElement(By.cssSelector("[aria-label=forms]")).click();

        var form = new Form(driver);
        form.setName("Blah");
        form.setEmail("blah@blah.com");
        form.clickAgree();

        // Act
        form.clickSubmit();

        // Assert
        Assertions.assertEquals("Thanks for your feedback Blah", form.getPopupText());
    }

    @AfterEach
    public void tearDown () {
        driver.quit();
    }

}
