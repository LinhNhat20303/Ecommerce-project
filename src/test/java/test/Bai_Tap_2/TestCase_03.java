package test.Bai_Tap_2;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;

public class TestCase_03 {
    @Test
    public void TestCase03() {

        // 1. Init web-driver session
        SoftAssert a = new SoftAssert();
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 2. Open target page - Tech Panda
            driver.get("http://live.techpanda.org/");

            // 3. Click on -> MOBILE -> menu
            WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
            mobileMenu.click();

            // 4. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile
            WebElement sonyXperiaMobile = driver
                    .findElement(By.cssSelector(".item .product-info .actions .btn-cart span"));
            sonyXperiaMobile.click();

            // 5. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an
            // error is displayed
            // The requested quantity for "Sony Xperia" is not available.
            WebElement input = driver.findElement(By.cssSelector(".product-cart-actions .input-text"));
            input.clear();
            input.sendKeys("1000");

            WebElement updateButton = driver.findElement(
                    By.xpath("/html/body/div[1]/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/button/span/span"));
            updateButton.click();

            WebElement errorElement = driver.findElement(By.cssSelector(".item-msg"));
            String errorMessage = errorElement.getText();
            // System.out.println(errorMessage);
            String expectedError = "The requested quantity for \"Sony Xperia\" is not available.";
            a.assertEquals(expectedError, errorMessage);
            // 6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A
            // message "SHOPPING CART IS EMPTY" is shown
            WebElement emptyCartButton = driver.findElement(By.cssSelector(".first .a-right .btn-empty"));
            emptyCartButton.click();

            WebElement actualMessageElement = driver.findElement(By.cssSelector(".cart-empty p"));
            String actualMessage = actualMessageElement.getText();
            String expectedMessage = "SHOPPING CART IS EMPTY";

            a.assertEquals(expectedMessage, actualMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
        a.assertAll();
        driver.quit();
    }
}