package test.Bai_Tap_2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.AssertJUnit.assertEquals;

import driver.driverFactory;

public class TestCase_02 {
    /*
     * 
     * Test Steps:
     * 
     * 1. Goto http://live.techpanda.org/
     * 
     * 2. Click on �MOBILE� menu
     * 
     * 3. In the list of all mobile , read the cost of Sony Xperia mobile (which is
     * $100)
     * 
     * 4. Click on Sony Xperia mobile
     * 
     * 5. Read the Sony Xperia mobile from detail page.
     * 
     * 6. Compare Product value in list and details page should be equal ($100).
     * 
     */
    @Test
    public void TestCase02() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 1. Goto http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            Thread.sleep(2000);
            WebElement out = driver.findElement(
                    By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[1]/span/span"));
            WebElement in = driver.findElement(By.xpath("#product-price-1 > span"));
            assertEquals(in, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
