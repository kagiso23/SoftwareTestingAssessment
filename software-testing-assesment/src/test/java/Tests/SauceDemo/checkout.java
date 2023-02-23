package Tests.SauceDemo;
import Pages.*;
import Utilities.Screenshot;
import Utilities.TextGenerator;
import Utilities.WebDriverAdapter;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import storage.Constants;

public class checkout extends TestBase {
    checkoutPage checkoutPage;
    StringBuilder generatedValue= TextGenerator.generateText();

    @BeforeTest
    public void before() throws Exception {
        super.before();
        checkoutPage = new checkoutPage(driver);
    }

    @Test
    public void checkoutProduct() throws Exception {
        logger = extent.createTest("[" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
        try {
            logger.createNode("Step : opening SauceDemo site");
            driver.get(aut_url);
            WebDriverAdapter.waitUntilObjectVisible(driver, By.name(Constants.loginButtonById));
            checkoutPage.getLoginDetails();
            logger.createNode("Step : Adding 2 products to the shopping cart");
            WebDriverAdapter.waitUntilObjectVisible(driver,By.xpath(Constants.productTextByXpath));
            Assert.assertEquals(checkoutPage.txt_Product.getText(),"PRODUCTS");
            checkoutPage.btn_AddToCartProduct1.click();
            checkoutPage.btn_AddToCartProduct2.click();
            logger.createNode("Step : Confirm that the correct products are added to the cart");
            checkoutPage.link_cartContainer.click();
            WebDriverAdapter.waitUntilObjectVisible(driver,By.xpath(Constants.cartTextByXpath));
            Assert.assertEquals(checkoutPage.txt_Cart.getText(),"YOUR CART");
            Assert.assertEquals(checkoutPage.txt_backPack.getText(),"Sauce Labs Backpack");
            Assert.assertEquals(checkoutPage.txt_BikeLight.getText(),"Sauce Labs Bike Light");
            logger.createNode("Step : Add information (first name, last name and postal code)");
            checkoutPage.btn_CheckOut.click();
            WebDriverAdapter.waitUntilObjectVisible(driver,By.xpath(Constants.checkOutInfoTextByXpath));
            Assert.assertEquals(checkoutPage.btn_CheckOutInfo.getText(),"CHECKOUT: YOUR INFORMATION");
            checkoutPage.field_firstName.sendKeys(generatedValue);
            checkoutPage.field_lastName.sendKeys(generatedValue);
            checkoutPage.field_postalCode.sendKeys(generatedValue);
            checkoutPage.btn_Continue.click();
            WebDriverAdapter.waitUntilObjectVisible(driver,By.xpath(Constants.checkOutOverviewTextXpath));
            Assert.assertEquals(checkoutPage.txt_checkOutOverview.getText(),"CHECKOUT: OVERVIEW");
            logger.createNode("Step : On the Checkout: Overview screen confirm that the total price is correct i.e. the sum of the two products");
            Assert.assertEquals(checkoutPage.txt_Total.getText(),"Total: $43.18");
            logger.createNode("Step : Finishing order");
            checkoutPage.btn_finish.click();
            WebDriverAdapter.waitUntilObjectVisible(driver,By.xpath(Constants.checkoutCompleteTextXpath));
            Assert.assertEquals(checkoutPage.txt_checkOutComplete.getText(),"CHECKOUT: COMPLETE!");
            Assert.assertEquals(checkoutPage.txt_thankYou.getText(),"THANK YOU FOR YOUR ORDER");
            checkoutPage.btn_backToHome.click();
            logger.createNode("Testing Completed");
        } catch (Exception e) {
            e.printStackTrace();
            Screenshot.getScreenshot(driver, "Unable to complete the order");
            logger.log(Status.FAIL, "Unable to complete the order");
        }
    }

}