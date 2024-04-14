package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.mystore.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    static ReadConfig readConfig = new ReadConfig();

    static String url = readConfig.getBaseUrl();
    static String browser = readConfig.getBrowser();

    public static WebDriver driver;
    public static Logger logger;

    public static void main(String[] args) {
        setup();
    }

    @BeforeClass
    public static void setup() {
        // launch browser
        switch (browser.toLowerCase()) {
            case "msedge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name provided: " + browser);
        }

        // implicit wait of 10 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // for logging
        logger = LogManager.getLogger("MyStoreV1");

        // open url
        driver.get(url);
        logger.info("URL opened: " + url);


    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                String testName = result.getMethod().getMethodName();
                captureScreenShot(driver, testName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // user method to capture screenshot
    public void captureScreenShot(WebDriver driver, String testName) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File src = screenshot.getScreenshotAs(OutputType.FILE);

        File dest = new File(System.getProperty("user.dir") + "/Screenshots/" + testName + ".png");
        FileUtils.copyFile(src, dest);
    }

}
