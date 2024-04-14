package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BrowserWindows {
    WebDriver ldriver;
    public BrowserWindows(WebDriver driver)
    {
        ldriver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text()='Browser Windows']")
     WebElement windowTextMsg;
    @FindBy(xpath = "//button[@title='New Tab']")
     WebElement windowNewTabBtn;
    @FindBy(xpath = "//button[normalize-space()='New Window']")
     WebElement windowNewWindowBtn;
    @FindBy(xpath = "//h1[text()='New Tab']")
     WebElement windowNewTabTextMsg;
    @FindBy(xpath = "//h1[text()='New Window']")
    WebElement windowNewWindowTextMsg;


public boolean verifyBrowserWindowElements(){
    Alert.alertMainDropDBtn.click();
    Alert.alertMainDropDBrowserWindowBtn.click();
    if (windowTextMsg.isDisplayed() && windowNewTabBtn.isDisplayed() && windowNewWindowBtn.isDisplayed()){
        System.out.println("All Elements of Browser Window are Displayed");
    }
    else {
        System.out.println("Failed to founds Elements of Browser Window");
    }
    return true;
}
public void newWindowHandle (){
    String currentWindow = ldriver.getWindowHandle();
    windowNewWindowBtn.click();
    Set<String> allWindowhandle = ldriver.getWindowHandles();
    for (String handle : allWindowhandle) {
        if (!handle.equals(currentWindow)) {
            ldriver.switchTo().window(handle);
            break;
        }
    }
    WebDriverWait wait = new WebDriverWait(ldriver, 10);
    if (windowNewWindowTextMsg.isDisplayed()){
        wait = new WebDriverWait(ldriver, 1);
    }
    ldriver.switchTo().window(currentWindow);
}

    public void newTabHandle (){
        String currentWindow = ldriver.getWindowHandle();
        windowNewTabBtn.click();
        Set<String> allWindowhandle = ldriver.getWindowHandles();
        for (String handle : allWindowhandle) {
            if (!handle.equals(currentWindow)) {
                ldriver.switchTo().window(handle);
                break;
            }
        }
        WebDriverWait wait = new WebDriverWait(ldriver, 10);
        if (windowNewTabTextMsg.isDisplayed()){
            wait = new WebDriverWait(ldriver, 1);
        }
        ldriver.switchTo().window(currentWindow);
    }

}




