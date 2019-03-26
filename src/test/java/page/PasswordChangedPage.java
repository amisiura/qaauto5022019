package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordChangedPage {
    private WebDriver driver;

    @FindBy (xpath = "//button[@id='reset-password-submit-button']")
    private WebElement buttonGoToHomePage;


    public PasswordChangedPage(WebDriver driver) {//
        this.driver = driver;
        PageFactory.initElements(driver, this); // this это класс, в данном случае текущий. Можно было указать page.LandingPage
    }

    public HomePage backToHomePage (){
        buttonGoToHomePage.click();
        return new HomePage(driver);
    }
}
