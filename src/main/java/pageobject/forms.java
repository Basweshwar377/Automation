package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;

public class forms {
    WebDriver ldriver;
    public forms(WebDriver driver)
    {
        ldriver = driver;
        PageFactory.initElements(driver, this);
    }

// All the expaths of Forms
    @FindBy(xpath = "//a[normalize-space()='Practice Form']")
    WebElement practiceFormbtn;
    @FindBy(xpath = "//input[@id='name']")
    WebElement practiceformName;
    @FindBy(xpath = "//input[@id='email']")
    WebElement practiceformEmail;
    @FindBy(xpath = "//input[@id='gender']")
    WebElement practiceformRadio;
    @FindBy(xpath = "//input[@id='mobile']")
    WebElement practiceformMobile;
    @FindBy(xpath = "//input[@id='dob']")
    WebElement practiceformDOB;
    @FindBy(xpath = "//input[@id='subjects']")
    WebElement practiceformSubject;
    @FindBy(xpath = "(//label[contains(text(),'Reading')]/../..//input[contains(@type,'checkbox')])[2]")
    WebElement practiceformCheckbox;
    @FindBy(xpath = "//input[@id='picture']")
    WebElement practiceformUploadPic;
    @FindBy(xpath = "//textarea[@id='picture']")
    WebElement practiceformCurrentAdd;
    @FindBy(xpath = "//select[@id='state']")
    WebElement practiceformDropDown1;
    @FindBy(xpath = "//select[@id='city']")
    WebElement practiceformDropDown2;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement practiceformLoginBtn;

    //Login Form elements////////////////////////////////////////////////////////////
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement loginFormbtn;
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Login In')]")
    WebElement loginWelcomeMsg;
    @FindBy(xpath = "//label[@for='email']")
    WebElement loginEmail;
    @FindBy(xpath = "//label[@for='password']")
    WebElement loginPassword;
    @FindBy(xpath = "//input[@id='email']")
    WebElement loginEmailID;
    @FindBy(xpath = "//input[@id='password']")
    WebElement loginPasswordID;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginBtn;
    @FindBy(xpath = "//a[@type='submit']")
    WebElement loginNewUser;
    //New User Form elements////////////////////////////////////////////////////////////
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement registerFormbtn;
    @FindBy(xpath = "//h1[contains(text(),'Welcome,Register')]")
    WebElement registerWelcomeMsg;
    @FindBy(xpath = "//input[@id='firstname']")
    WebElement registerFirstName;
    @FindBy(xpath = "//input[@id='lastname']")
    WebElement registerLastName;
    @FindBy(xpath = "//input[@id='username']")
    WebElement registerUserName;
    @FindBy(xpath = "//input[@id='password']")
    WebElement registerPassword;
    @FindBy(xpath = "//input[@value='Register']")
    WebElement registerBtn;
    @FindBy(xpath = "//a[@type='submit']")
    WebElement registerBacktoLogin;




    //"verifying Web Elements of Practice Form"
    public boolean  verifyPracticeFormDetails() {
        //Check that all the elements are visible

      if (practiceFormbtn.isDisplayed() && loginFormbtn.isDisplayed() && registerFormbtn.isDisplayed() && practiceformName.isDisplayed()
              && practiceformEmail.isDisplayed() && practiceformRadio.isDisplayed() && practiceformMobile.isDisplayed() && practiceformDOB.isDisplayed()
              && practiceformSubject.isDisplayed() && practiceformCheckbox.isDisplayed() && practiceformUploadPic.isDisplayed() && practiceformCurrentAdd.isDisplayed()){
                  System.out.println("All Elements of Practice forms are Displayed");
            }
      else {
          System.out.println("Failed to founds Elements of Practice Form");
        }
      return true;

    }

    public void fillPracticeForm()  {

        if(practiceformName.isDisplayed()){
            practiceformName.sendKeys("Basweshwar Bande");
            practiceformEmail.sendKeys("basweshwarbande98@gmail.com");
            practiceformRadio.click();
            practiceformMobile.sendKeys("8830532879" + Keys.ENTER + "12/12/2024" + Keys.ENTER);
            practiceformSubject.sendKeys("Task to automate the tutorials point site");
            practiceformCheckbox.click();
            practiceformUploadPic.sendKeys(System.getProperty("user.dir") + "\\TestData\\img.png");
            practiceformCurrentAdd.sendKeys("At Pune");
            Select select = new Select(practiceformDropDown1);
            select.selectByVisibleText("Haryana");
            Select select2 = new Select(practiceformDropDown2);
            select2.selectByVisibleText("Agra");
            practiceformLoginBtn.click();

        }
        else {
            practiceformName.sendKeys("Basweshwar Bande");
            practiceformEmail.sendKeys("basweshwarbande98@gmail.com");
            practiceformRadio.click();
            practiceformMobile.sendKeys("8830532879" + Keys.ENTER + "12/12/2024" + Keys.ENTER);
            practiceformSubject.sendKeys("Task to automate the tutorials point site");
            practiceformCheckbox.click();
            practiceformUploadPic.sendKeys(System.getProperty("user.dir") + "\\TestData\\img.png");
            practiceformCurrentAdd.sendKeys("At Pune");
            Select select = new Select(practiceformDropDown1);
            select.selectByVisibleText("Haryana");
            Select select2 = new Select(practiceformDropDown2);
            select2.selectByVisibleText("Agra");
            practiceformLoginBtn.click();
        }
    }

    public boolean verifyLoginFormDetails() {
        //Check that all the elements are visible
        loginFormbtn.click();
        if (loginWelcomeMsg.isDisplayed() && loginEmail.isDisplayed() && loginPassword.isDisplayed() && loginEmailID.isDisplayed() && loginBtn.isDisplayed() && loginNewUser.isDisplayed() && loginPasswordID.isDisplayed()) {
            System.out.println("All Elements of Login form are Displayed");
        } else {
            System.out.println("Failed to founds Elements of Login Form");
        }
        return true;
    }

    public void fillLoginform()  {
        if(loginWelcomeMsg.isDisplayed()){
            loginEmailID.sendKeys("basweshwarbande98@gmail.com");
            loginPasswordID.sendKeys("Pass@1234");
            loginBtn.click();
        }else {
            loginFormbtn.click();
            loginEmailID.sendKeys("basweshwarbande98@gmail.com");
            loginPasswordID.sendKeys("Pass@1234");
            loginBtn.click();
        }
    }


    public boolean verifyRegisterFormDetails() {
        //Check that all the elements are visible
        registerBacktoLogin.click();
        if (registerBtn.isDisplayed() && registerPassword.isDisplayed() && registerBacktoLogin.isDisplayed() && registerLastName.isDisplayed() && registerUserName.isDisplayed() && registerWelcomeMsg.isDisplayed()) {
            System.out.println("All Elements of Register form are Displayed");
        } else {
            System.out.println("Failed to founds Elements of Register Form");
        }
        return true;
    }

    public void fillRegisterUserform()  {
        if(registerWelcomeMsg.isDisplayed()){
            registerFirstName.sendKeys("Basweshwar");
            registerLastName.sendKeys("Bande");
            registerUserName.sendKeys("Basu");
            registerPassword.sendKeys("Pass@1234");
            registerBacktoLogin.click();
            if(loginWelcomeMsg.isDisplayed()){
                System.out.println("Login Form is UI is on the Screen");
            }
        }
    }




}
