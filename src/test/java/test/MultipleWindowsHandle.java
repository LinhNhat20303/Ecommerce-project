package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindowsHandle {
    @Test
    public void testMultipleWindowsHandle() {

        // DRY - "Don't Repeat Yourself
        // 1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();

        // 7. Quit browser session
        driver.quit();
    }
}
