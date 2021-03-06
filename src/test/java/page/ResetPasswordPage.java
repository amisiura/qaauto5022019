package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.BaseTest;



public class ResetPasswordPage extends BasePage {

    @FindBy (xpath = "//input[@id='newPassword']")
    private WebElement newPasswordField;

    @FindBy (xpath = "//input[@id='confirmPassword']")
    private WebElement newPasswordFieldConfirm;

    @FindBy (xpath = "//button[@id='reset-password-submit-button']")
    private WebElement buttonConfirm;

    public ResetPasswordPage(WebDriver driver) {//
        this.driver = driver;
        PageFactory.initElements(driver, this); // this это класс, в данном случае текущий. Можно было указать page.LandingPage
    }


    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/request-password-reset-submit");//&&
    }


    public PasswordChangedPage setNewPassword(String newPassword) throws InterruptedException{
        driver.get(resetPasswordURL);
        newPasswordField.sendKeys(newPassword);
        newPasswordFieldConfirm.sendKeys(newPassword);
        buttonConfirm.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        return new PasswordChangedPage(driver);


    }
}
