package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class that decsribes LandingPage pageObject
 */
public class LandingPage extends BasePage {

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement fieldUserEmailField;//

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement fieldUserPasswordField;//

    @FindBy(id = "login-submit")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//a[@class=\"link-forgot-password\"]")
    private WebElement buttonForgotPassword;

    /**
     * Constructor of LandingPage class
     * @param driver Browser object from Test
     */
    public LandingPage(WebDriver driver) {//
        this.driver = driver;
        PageFactory.initElements(driver, this); // this это класс, в данном случае текущий. Можно было указать page.LandingPage
    }


    /**login is a method that allows login into linkedin account
     * @param userEmail is a email of your linkedin account
     * @param userPassword is a password of your account
     * @param expectedPage object of class ExpectedPage
     * @param <ExpectedPage> class ExpectedPage
     * @return
     */
    public <ExpectedPage> ExpectedPage login(String userEmail, String userPassword, Class<ExpectedPage> expectedPage) {// полиморфизм
        fieldUserEmailField.sendKeys(userEmail);
        fieldUserPasswordField.sendKeys(userPassword);
        buttonSubmit.sendKeys(Keys.ENTER);
        return PageFactory.initElements(driver, expectedPage);
    }

    ////////////////////////


    /**login is a method that allows login into linkedin account
     * @param userEmail is a email of your linkedin account
     * @param userPassword is a password of your account
     * @param <ExpectedPage> generic class ExpectedPage
     * @return
     */
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


    /** method that checks if page loaded
     * @return boolean value that is result of checking
     */
    public boolean isPageLoaded() {
        return
                //   buttonSubmit.isDisplayed();//&&
                driver.getCurrentUrl().contains("https://www.linkedin.com/");//&&
        //     driver.getTitle().contains("Log In or Sign Up");
    }

    /** method that push button "Forgot Password"
     * @return new page that allows input email to reset password
     */
    public ForgotPasswordPage resetPassword (){
        buttonForgotPassword.sendKeys(Keys.ENTER);
        return new ForgotPasswordPage(driver);
    }

}
