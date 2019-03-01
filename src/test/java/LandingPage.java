
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    private WebDriver driver;

    @FindBy(xpath="//input[@id='login-email']")
    private WebElement fieldUserEmailField ;//

    @FindBy(xpath="//input[@id='login-password']")
    private WebElement fieldUserPasswordField ;//

    @FindBy(id="login-submit")
    private WebElement buttonSubmit ;//

    public LandingPage(WebDriver driver) {//
        this.driver=driver;
        PageFactory.initElements(driver, this); // this это класс, в данном случае текущий. Можно было указать LandingPage
    }



    public Object login (String userEmail, String userPassword, int source) {
        fieldUserEmailField.sendKeys(userEmail);
        fieldUserPasswordField.sendKeys(userPassword);
        buttonSubmit.sendKeys(Keys.ENTER);
        if (source == 1)
            {return new HomePage(driver);
            }
        else
        {return new LoginSubmit(driver);
        }
    }

/*    public LoginSubmit loginToLoginSubmit (String userEmail, String userPassword ) {
        fieldUserEmailField.sendKeys(userEmail);
        fieldUserPasswordField.sendKeys(userPassword);
        buttonSubmit.sendKeys(Keys.ENTER);
        return new LoginSubmit(driver);
    }*/




    public boolean isPageLoaded() {
        return
             //   buttonSubmit.isDisplayed();//&&
                driver.getCurrentUrl().contains("https://www.linkedin.com/") ;//&&
                   //     driver.getTitle().contains("Log In or Sign Up");
    }
}
