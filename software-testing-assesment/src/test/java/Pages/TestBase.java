package Pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {
    public static final String aut_url = "https://www.saucedemo.com/";
    public static RemoteWebDriver driver;
    public ExtentSparkReporter report = new ExtentSparkReporter("C:\\SoftwareTestingAssessment\\Reports\\TestReport_" + new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date()) + ".html");
    public static ExtentTest logger;
    public static ExtentReports extent;
    @BeforeClass
    public void before() throws Exception{

        System.setProperty("webdriver.chrome.driver","C:\\SoftwareTestingAssessment\\software-testing-assesment\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        extent = new ExtentReports();
        extent.attachReporter(report);
        report.config().setTheme(Theme.DARK);
        report.config().setDocumentTitle("Assessment Test Report");
        report.config().setReportName("Automation Tests Report");
        extent.setSystemInfo("Environment", "Prod");
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if (ITestResult.FAILURE == result.getStatus()) {

            logger.log(Status.FAIL, result.getName() + " Failed");
            logger.log(Status.FAIL, "Logs For " + result.getName() + "\n  " + result.getThrowable());
        } else if (ITestResult.SKIP == result.getStatus()) {
            logger.log(Status.SKIP, result.getName() + " Skipped");
        } else if (ITestResult.SUCCESS == result.getStatus()) {
            logger.log(Status.PASS, result.getName() + " Passed");
        }
    }

    @AfterClass
    public void after() {
        if (driver != null) {
            driver.quit();
            extent.flush();
        }
    }
}
