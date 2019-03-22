package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement fieldUserEmailField;//

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement fieldUserPasswordField;//

    @FindBy(id = "login-submit")
    private WebElement buttonSubmit;//

    public LandingPage(WebDriver driver) {//
        this.driver = driver;
        PageFactory.initElements(driver, this); // this это класс, в данном случае текущий. Можно было указать page.LandingPage
    }

/*
    public Object login2(String userEmail, String userPassword, int source) {
        fieldUserEmailField.sendKeys(userEmail);
        fieldUserPasswordField.sendKeys(userPassword);
        buttonSubmit.sendKeys(Keys.ENTER);
        if (source == 1) {
            return new page.HomePage(driver);
        } else {
            return new page.LoginSubmitPage(driver);
        }
    }*/
    ///////////////////////

    public <ExpectedPage> ExpectedPage login(String userEmail, String userPassword, Class<ExpectedPage> expectedPage) {// полиморфизм
        fieldUserEmailField.sendKeys(userEmail);
        fieldUserPasswordField.sendKeys(userPassword);
        buttonSubmit.sendKeys(Keys.ENTER);
        return PageFactory.initElements(driver, expectedPage);
    }

    ////////////////////////



    public <ExpectedPage> ExpectedPage login(String userEmail, String userPassword) {//делаем с Николаем правильно приведение двух методов к одному
        fieldUserEmailField.sendKeys(userEmail);
        fieldUserPasswordField.sendKeys(userPassword);
        buttonSubmit.sendKeys(Keys.ENTER);
        if (driver.getCurrentUrl().contains("/feed")) {
            return (ExpectedPage) new HomePage(driver);
        } else {
            return (ExpectedPage) new LoginSubmitPage(driver);
        }
    }

/*    public page.LoginSubmitPage loginToLoginSubmit (String userEmail, String userPass  word ) {
        fieldUserEmailField.sendKeys(userEmail);
        fieldUserPasswordField.sendKeys(userPassword);
        buttonSubmit.sendKeys(Keys.ENTER);
        return new page.LoginSubmitPage(driver);
    }*/


    public boolean isPageLoaded() {
        return
                //   buttonSubmit.isDisplayed();//&&
                driver.getCurrentUrl().contains("https://www.linkedin.com/");//&&
        //     driver.getTitle().contains("Log In or Sign Up");
    }
}
