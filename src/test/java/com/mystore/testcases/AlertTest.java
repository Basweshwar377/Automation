package com.mystore.testcases;

import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.Alert;
import pageobject.forms;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class AlertTest  extends BaseTest {

    Alert alert = new Alert(driver);

    @BeforeMethod
    public void setUp_Driver() throws NoSuchAlgorithmException, IOException {
        alert = new Alert(driver);
    }

    @Test (priority = 1)
    public void verifyAlertOne() throws InterruptedException {
        alert.handleAlert1();

    }
    @Test (priority = 2)
    public void verifyAlertTwo() throws InterruptedException {
        alert.handleAlert2();

    }
    @Test (priority = 3)
    public void verifyAlertThree() throws InterruptedException {
        alert.handleAlert3();

    }
    @Test (priority = 4)
    public void verifyAlertFour() throws InterruptedException {
        alert.handleAlert4();

    }
    @AfterClass
    public void shutdown() throws InterruptedException {
        driver.quit();
    }

}



