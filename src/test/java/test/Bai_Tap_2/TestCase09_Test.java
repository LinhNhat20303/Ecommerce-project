package test.Bai_Tap_2;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase09_Test {
    @Test
    public void Main() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        TestCase09_Page page = new TestCase09_Page(driver);

        page.clickOnMobileMenu();
        page.addToCartIphone();
        page.enterCouponCode("GURU50");
        page.clickApplyCouponButton();

        Assert.assertEquals(page.DiscountedPrice(), page.Price() * 0.95);
        System.out.println("Price is discounted by 5%");

        driver.quit();
    }
}