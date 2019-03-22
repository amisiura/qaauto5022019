package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSubmitPage {

    private WebDriver driver;

    @FindBy(xpath="//div[@id='error-for-username']")
    private WebElement userNameError;

    @FindBy(xpath="//div[@id='error-for-password']")
    private WebElement passwordError;

    @FindBy(xpath="//form[@class='login__form']")
    private WebElement loginForm;

    public LoginSubmitPage(WebDriver driver) {//
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded(){
      return
              loginForm.isDisplayed();
    }

    public String getUserNameErrorGetText(){
        return
                userNameError.getText();
    }

    public String getPasswordErrorGetText(){
        return
                passwordError.getText();
    }

}

