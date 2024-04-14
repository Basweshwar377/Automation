package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert {
    WebDriver ldriver;
    public Alert(WebDriver driver)
    {
        ldriver = driver;
        PageFactory.initElements(driver, this);
    }

    //All xpath of Alert page
    @FindBy(xpath = "//button[normalize-space()='Alerts, Frames & Windows']")
    static WebElement alertMainDropDBtn;
    @FindBy(xpath = "//a[normalize-space()='Browser Windows']")
    static WebElement alertMainDropDBrowserWindowBtn;
    @FindBy(xpath = "//a[normalize-space()='Alerts']")
    static WebElement alertDropDAlertsBtn;
    @FindBy(xpath = "//a[normalize-space()='Frames']")
    static WebElement alertMainDropDFrameBtn;
    @FindBy(xpath = "//h1[text()='Alerts']")
     WebElement alertTextMsg;
    @FindBy(xpath = "//button[normalize-space()='Alert']")
     WebElement alertButton1;
    @FindBy(xpath = "//button[@onclick='myMessage()']")
     WebElement alertButton2;
    @FindBy(xpath = "//button[@onclick='myDesk()']")
     WebElement alertButton3;
    @FindBy(xpath = "//button[@onclick='myPromp()']")
     WebElement alertButton4;


    public boolean  verifyAlertElements() {
        //Check that all the elements are visible
        alertMainDropDBtn.click();
        alertDropDAlertsBtn.click();

        if (alertTextMsg.isDisplayed() && alertButton1.isDisplayed() && alertButton2.isDisplayed() && alertButton3.isDisplayed() && alertButton4.isDisplayed()){
            System.out.println("All Elements of Alerts are Displayed");
        }
        else {
            System.out.println("Failed to founds Elements of Alerts");
        }
        return true;

    }

    public void handleAlert1(){
        verifyAlertElements();
        alertButton1.click();
        org.openqa.selenium.Alert alert1 = ldriver.switchTo().alert();
        String alertText = alert1.getText();
        System.out.println("Alert text: " + alertText);
        alert1.accept();
    }

    public void handleAlert2(){
        verifyAlertElements();
        alertButton2.click();
        WebDriverWait wait = new WebDriverWait(ldriver, 5);
        org.openqa.selenium.Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        alert.accept();
    }

    public void handleAlert3(){
        verifyAlertElements();
        alertButton3.click();
        WebDriverWait wait = new WebDriverWait(ldriver, 1);
        org.openqa.selenium.Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        alert.accept();
    }
    public void handleAlert4(){
        verifyAlertElements();
        alertButton4.click();
        WebDriverWait wait = new WebDriverWait(ldriver, 1);
        org.openqa.selenium.Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        String name = "Basweshwar Bande";
        alert.sendKeys(name);
        alert.accept();
    }


}
