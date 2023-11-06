package test.Bai_Tap_2;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class TestCase_01 {
    @Test
    public void TestCase01() {

        // 1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 2. Open target page - Login Form
            driver.get("http://live.techpanda.org/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement title = driver.findElement(By.cssSelector("h2:nth-child(1)"));
            assertEquals("THIS IS DEMO SITE FOR   ", title.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}