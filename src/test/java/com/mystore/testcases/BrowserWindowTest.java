package com.mystore.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.Alert;
import pageobject.BrowserWindows;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class BrowserWindowTest extends BaseTest {

    public Alert alert;
    BrowserWindows browserWindows = new BrowserWindows(driver);

    @BeforeMethod
    public void setUp_Driver() throws NoSuchAlgorithmException, IOException {
        browserWindows = new BrowserWindows(driver);
        alert = new Alert(driver);
    }
    @Test(priority = 1)
    public void verifyWindowHandle() throws InterruptedException {
        browserWindows.verifyBrowserWindowElements();
        browserWindows.newWindowHandle();
    }
    @Test(priority = 2)
    public void verifyTabHandle() throws InterruptedException {
        browserWindows.verifyBrowserWindowElements();
        browserWindows.newTabHandle();
    }
    @AfterClass
    public void shutdown() throws InterruptedException {
        driver.quit();
    }

}
