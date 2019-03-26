package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ForgotPasswordPage {

    private WebDriver driver;
    @FindBy(xpath = "//input[@name=\"userName\"]")
    private WebElement mailResetPassword;

    @FindBy(xpath = "//button[@id=\"reset-password-submit-button\"]")
    private WebElement sendLetterOnMailToResetPassword;


    public ForgotPasswordPage(WebDriver driver) {//
        this.driver = driver;
        PageFactory.initElements(driver, this); // this это класс, в данном случае текущий. Можно было указать page.LandingPage
    }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/request-password-reset");
    }

    public ResetPasswordPage  resetPassword(String userEmail) {
        mailResetPassword.sendKeys(userEmail);
        sendLetterOnMailToResetPassword.sendKeys(Keys.ENTER);
        return new ResetPasswordPage(driver);
    }


}