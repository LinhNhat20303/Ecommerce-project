package test.Bai_Tap_2;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestCase_04 {
        @Test
        public void TestCase04() {
                // 1. Init web-driver session
                WebDriver driver = driverFactory.getChromeDriver();
                try {
                        // 2. Open target page - Tech Panda
                        driver.get("http://live.techpanda.org/");

                        // 3. Click on -> MOBILE -> menu
                        WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
                        mobileMenu.click();

                        // 4. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony
                        // Xperia & Iphone)
                        WebElement sonyXperiaMobile = driver.findElement(By
                                        .cssSelector(".products-grid li:nth-child(2) .product-info .actions .add-to-links .link-compare"));
                        sonyXperiaMobile.click();

                        WebElement iphone = driver.findElement(By
                                        .cssSelector(".products-grid li:nth-child(3) .product-info .actions .add-to-links .link-compare"));
                        iphone.click();

                        // 5. Click on �COMPARE� button. A popup window opens
                        WebElement compareProductsButton = driver
                                        .findElement(By.cssSelector(".block-compare .block-title span"));
                        compareProductsButton.click();

                        WebElement compareButton = driver
                                        .findElement(By.cssSelector(".block-compare .block-content .actions .button"));
                        compareButton.click();

                        // Sony Xperia Mobile + Iphone in Compare Products
                        WebElement sonyXperiaInCompareProducts = driver
                                        .findElement(By.cssSelector(
                                                        ".block-compare .block-content #compare-items .odd .product-name a"));
                        WebElement iphoneInCompareProducts = driver
                                        .findElement(By.cssSelector(
                                                        ".block-compare .block-content #compare-items .last .product-name a"));

                        String sonyXperiaName = sonyXperiaInCompareProducts.getText();
                        String IphoneName = iphoneInCompareProducts.getText();

                        for (String handle : driver.getWindowHandles()) {
                                driver.switchTo().window(handle);
                        }

                        WebElement titleElement = driver.findElement(By.cssSelector(".page-title h1"));
                        String actualTitle = titleElement.getText();
                        String expectedTitle = "COMPARE PRODUCTS";

                        WebElement firstProduct = driver
                                        .findElement(By.cssSelector("h2[class='product-name'] a[title='Sony Xperia']"));
                        WebElement secondProduct = driver
                                        .findElement(By.cssSelector("h2[class='product-name'] a[title='IPhone']"));
                        String firstProductName = firstProduct.getText();
                        String secondProductName = secondProduct.getText();

                        assertEquals(expectedTitle, actualTitle);
                        assertEquals(sonyXperiaName, firstProductName);
                        assertEquals(IphoneName, secondProductName);

                } catch (Exception e) {
                        e.printStackTrace();
                }
                driver.quit();
        }
}
