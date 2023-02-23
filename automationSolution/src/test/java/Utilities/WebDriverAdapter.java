package Utilities;

import Pages.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WebDriverAdapter extends TestBase {
    public static void waitUntilObjectVisible(WebDriver driver, By element) {
        logger.createNode("[" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            logger.info(element.toString() +" is not found");
        }
    }
}
