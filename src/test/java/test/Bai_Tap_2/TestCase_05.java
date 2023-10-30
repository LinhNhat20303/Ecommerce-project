package test.Bai_Tap_2;

import driver.driverFactory;
import POM.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.testng.AssertJUnit.assertEquals;

public class TestCase_05 {
        @Test
        public void TestCase04() {
                // 1. Initiate a SoftAssert instance
                SoftAssert softAssert = new SoftAssert();

                // 2. Initialize the WebDriver using a driver factory
                WebDriver driver = driverFactory.getChromeDriver();

                try {
                        // 3. Open the Tech Panda website
                        driver.get("http://live.techpanda.org/");

                        // 4. Click on "MY ACCOUNT" link
                        RegisterPage registerPage = new RegisterPage(driver);
                        registerPage.ClickMyAccountLink();

                        // 5. Click "CREATE AN ACCOUNT" link and fill New User information excluding the
                        // registered Email ID.
                        registerPage.ClickCreateAccount();
                        registerPage.enterFirstName(generateRandomString(8));
                        registerPage.enterLastName(generateRandomString(8));
                        String password = generateRandomString(8);
                        registerPage.enterEmail(generateRandomEmail());
                        registerPage.enterPassword(password);
                        registerPage.enterConfirmPassword(password);
                        registerPage.clickRegister();

                        // 6. Verify Registration is done. Expected account registration done.
                        // Add an assertion for account registration, e.g., by checking for a success
                        // message or a unique element.

                        // 7. Go to TV menu
                        // You can add steps to navigate to the TV menu here.
                        WebElement TV = driver
                                        .findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[2]/a"));
                        TV.click();

                        // 8. Add a product (e.g., LG LCD) to your wishlist
                        // You can add steps to add a product to the wishlist here.
                        WebElement addTV = driver
                                        .findElement(
                                                        By.xpath(
                                                                        "/html/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a"));
                        addTV.click();

                        // 9. Click "SHARE WISHLIST"
                        // You can add steps to click the SHARE WISHLIST button here.
                        WebElement share = driver
                                        .findElement(
                                                        By.xpath(
                                                                        "/html/body/div/div/div[2]/div/div[2]/div/div[1]/form[1]/div/div/button[1]"));
                        share.click();
                        // 10. In the next page, enter an Email and a message and click SHARE WISHLIST
                        // You can add steps to enter the email and message and share the wishlist here.

                        WebElement input1 = driver
                                        .findElement(
                                                        By.xpath(
                                                                        "/html/body/div/div/div[2]/div/div[2]/div/form/div[1]/ul/li[1]/div/textarea"));
                        input1.clear();
                        input1.sendKeys("johndoe@domain.com, johnsmith@domain.com ");
                        WebElement input2 = driver
                                        .findElement(
                                                        By.xpath(
                                                                        "/html/body/div/div/div[2]/div/div[2]/div/form/div[1]/ul/li[2]/div/textarea"));
                        input2.clear();
                        input2.sendKeys("commit -m");

                        // 11. Check wishlist is shared. Expected wishlist shared successfully.
                        // Add an assertion to check if the wishlist is shared successfully.

                        // click the share wishlist Button
                        /// html/body/div/div/div[2]/div/div[2]/div/form/div[2]/button
                        WebElement shareWishlistButton = driver
                                        .findElement(
                                                        By.xpath(
                                                                        "/html/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li"));
                        shareWishlistButton.click();

                        WebElement allert = driver
                                        .findElement(
                                                        By.xpath(
                                                                        "/html/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li"));

                        assertEquals(allert, "Your Wishlist has been shared.");
                } catch (Exception e) {
                        e.printStackTrace();
                        softAssert.fail("Test case failed: " + e.getMessage());
                } finally {

                        driver.quit();
                }

        }

        // Function to generate a random string of the specified length
        public String generateRandomString(int length) {
                String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                StringBuilder randomString = new StringBuilder();
                for (int i = 0; i < length; i++) {
                        int index = (int) (Math.random() * characters.length());
                        randomString.append(characters.charAt(index));
                }
                return randomString.toString();
        }

        // Function to generate a random email address
        public String generateRandomEmail() {
                String randomString = generateRandomString(8);
                return randomString + "@example.com";
        }

}
