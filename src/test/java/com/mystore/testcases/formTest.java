package com.mystore.testcases;

import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.forms;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class formTest  extends BaseTest {

    forms form = new forms(driver);


    @BeforeMethod
    public void setUp_Driver() throws NoSuchAlgorithmException, IOException {
        form = new forms(driver);
    }

    @Test (priority = 1)
    public void verifyPracticeForm() throws InterruptedException {

        form.verifyPracticeFormDetails();
        form.fillPracticeForm();
        }

    @Test(priority = 2)
    public void verifyLoginForm() throws InterruptedException {
        form.verifyLoginFormDetails();
        form.fillLoginform();
    }

    @Test(priority = 3)
    public void verifyRegisterForm() throws InterruptedException {
        form.verifyRegisterFormDetails();
        form.fillRegisterUserform();
    }

    @AfterClass
    public void shutdown() throws InterruptedException {
        driver.quit();
    }

    }



