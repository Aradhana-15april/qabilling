package Base;


import com.obsqura.constants.Constants;
import com.obsqura.utilities.ScreenshotUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.util.Properties;


public class TestHelper {

    public static WebDriver driver;
    Properties prop;
    FileInputStream ip;
    ScreenshotUtility screenshot=new ScreenshotUtility();

    public TestHelper() {
        prop = new Properties();
        try {
            ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }


    }

    public void initialize(String browser, String url) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Parameters("browser")
    @BeforeMethod(enabled = false)
    public void launchCrossBrowserSession(String browser) {
        String url = prop.getProperty("url");
        initialize(browser, url);
    }

    @BeforeMethod(enabled = true,alwaysRun = true)

    public void launchBrowser() {
        String browser = prop.getProperty("browser");

        String url = prop.getProperty("url");
        System.out.println("Execution started");
        initialize(browser, url);

    }
    @AfterMethod()
    public void tearDown(ITestResult itestresult){
        if (itestresult.getStatus()==ITestResult.FAILURE);
        {

            screenshot.takeScreenshot(driver,itestresult.getName());
        }


    }
}

