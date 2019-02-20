import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    WebElement profileMenuItem;

    public HomePage(WebDriver driver) {//
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
    }

    public boolean meIcon() {
        return
                profileMenuItem.isDisplayed();
    }
}

