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

public class AddProductsToTheCart extends TestBase {
    AddProductsPage addProductsPage;
    StringBuilder generatedValue= TextGenerator.generateText();

    @BeforeTest
    public void before() throws Exception {
        super.before();
        addProductsPage = new AddProductsPage(driver);
    }

    @Test
    public void addProductToCart() throws Exception {
        logger = extent.createTest("[" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
        try {
            logger.createNode("Step : opening SauceDemo site");
            driver.get(aut_url);
            WebDriverAdapter.waitUntilObjectVisible(driver, By.name(Constants.loginButtonById));
            addProductsPage.getLoginDetails();
            logger.createNode("Step : Adding 2 products to the shopping cart");
            WebDriverAdapter.waitUntilObjectVisible(driver,By.xpath(Constants.productTextByXpath));
            Assert.assertEquals(addProductsPage.txt_Product.getText(),"PRODUCTS");
            addProductsPage.btn_AddToCartProduct1.click();
            addProductsPage.btn_AddToCartProduct2.click();
            logger.createNode("Step : Confirm that the correct products are added to the cart");
            addProductsPage.link_cartContainer.click();
            WebDriverAdapter.waitUntilObjectVisible(driver,By.xpath(Constants.cartTextByXpath));
            Assert.assertEquals(addProductsPage.txt_Cart.getText(),"YOUR CART");
            Assert.assertEquals(addProductsPage.txt_backPack.getText(),"Sauce Labs Backpack");
            Assert.assertEquals(addProductsPage.txt_BikeLight.getText(),"Sauce Labs Bike Light");
            logger.createNode("Step : Add information (first name, last name and postal code)");
            addProductsPage.btn_CheckOut.click();
            WebDriverAdapter.waitUntilObjectVisible(driver,By.xpath(Constants.checkOutInfoTextByXpath));
            Assert.assertEquals(addProductsPage.btn_CheckOutInfo.getText(),"CHECKOUT: YOUR INFORMATION");
            addProductsPage.field_firstName.sendKeys(generatedValue);
            addProductsPage.field_lastName.sendKeys(generatedValue);
            addProductsPage.field_postalCode.sendKeys(generatedValue);
            addProductsPage.btn_Continue.click();
            WebDriverAdapter.waitUntilObjectVisible(driver,By.xpath(Constants.checkOutOverviewTextXpath));
            Assert.assertEquals(addProductsPage.txt_checkOutOverview.getText(),"CHECKOUT: OVERVIEW");
            logger.createNode("Step : On the Checkout: Overview screen confirm that the total price is correct i.e. the sum of the two products");
            Assert.assertEquals(addProductsPage.txt_Total.getText(),"Total: $43.18");
            logger.createNode("Step : Finishing order");
            addProductsPage.btn_finish.click();
            WebDriverAdapter.waitUntilObjectVisible(driver,By.xpath(Constants.checkoutCompleteTextXpath));
            Assert.assertEquals(addProductsPage.txt_checkOutComplete.getText(),"CHECKOUT: COMPLETE!");
            Assert.assertEquals(addProductsPage.txt_thankYou.getText(),"THANK YOU FOR YOUR ORDER");
            addProductsPage.btn_backToHome.click();
            logger.createNode("Testing Completed");
        } catch (Exception e) {
            e.printStackTrace();
            Screenshot.getScreenshot(driver, "Unable to complete the order");
            logger.log(Status.FAIL, "Unable to complete the order");
        }
    }

}