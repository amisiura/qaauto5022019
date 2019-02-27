import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    WebElement profileMenuItem;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded() {
        return
                profileMenuItem.isDisplayed()
                        && driver.getCurrentUrl().contains("/feed")
                        && driver.getTitle().contains("LinkedIn");
    }
}




