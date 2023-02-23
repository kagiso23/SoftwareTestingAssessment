package Pages;

import Utilities.JsonUtil;
import com.google.gson.JsonObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import storage.Constants;

public class checkoutPage extends TestBase {


    @FindBy(id = Constants.loginButtonById)
    public WebElement btn_Login;
    @FindBy(id = Constants.userNameFieldById)
    public WebElement field_UserName;
    @FindBy(id = Constants.passwordFieldById)
    public WebElement field_Password;
    @FindBy(xpath = Constants.productTextByXpath )
    public WebElement txt_Product;
    @FindBy(id = Constants.product1AddToCartById)
    public WebElement btn_AddToCartProduct1;
    @FindBy(id = Constants.product2AddToCartById)
    public WebElement btn_AddToCartProduct2;
    @FindBy(id = Constants.cartContainerById)
    public WebElement link_cartContainer;
    @FindBy(xpath = Constants.backPackTextByXpath)
    public WebElement txt_backPack;
    @FindBy(xpath = Constants.bikeLightTextByXpath)
    public WebElement txt_BikeLight;
    @FindBy(id = Constants.checkoutButtonId)
    public WebElement btn_CheckOut;
    @FindBy(xpath = Constants.checkOutInfoTextByXpath)
    public WebElement btn_CheckOutInfo;
    @FindBy(xpath = Constants.cartTextByXpath)
    public WebElement txt_Cart;
    @FindBy(id = Constants.firstNameFieldById)
    public WebElement field_firstName;
    @FindBy(id = Constants.lastNameFieldById)
    public WebElement field_lastName;
    @FindBy(id = Constants.postalCodeFieldById)
    public WebElement field_postalCode;
    @FindBy(id= Constants.continueButtonById)
    public WebElement btn_Continue;
    @FindBy(xpath = Constants.checkOutOverviewTextXpath)
    public WebElement txt_checkOutOverview;
    @FindBy(xpath = Constants.totalTextXpath)
    public WebElement txt_Total;
    @FindBy(id = Constants.finishButtonId)
    public WebElement btn_finish;
    @FindBy(xpath = Constants.checkoutCompleteTextXpath)
    public WebElement txt_checkOutComplete;
    @FindBy(xpath = Constants.thankYouTextXpath)
    public WebElement txt_thankYou;
    @FindBy(id = Constants.backToHomeButtonId)
    public WebElement btn_backToHome;
    public static final String loginDetailsJsonFilePath ="C:\\SoftwareTestingAssessment\\resources\\LoginDetails.json";

    public void getLoginDetails() throws Exception {
        JsonObject login = JsonUtil.readJSON("LoginDetails",loginDetailsJsonFilePath);
        String valueUsername = String.valueOf(login.get("Username"));
        String valuePassword = String.valueOf(login.get("Password"));
        String Username =  valueUsername.substring(1, valueUsername.length() - 1);
        field_UserName.sendKeys(Username);
        String Password = valuePassword.substring(1, valuePassword.length() - 1);
        field_Password.sendKeys(Password);
        btn_Login.click();
    }

    public checkoutPage(WebDriver driver) throws Exception {

        PageFactory.initElements(new AjaxElementLocatorFactory(driver,60),this);
    }
}
