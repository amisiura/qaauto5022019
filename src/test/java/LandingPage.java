import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    WebDriver driver;

    WebElement fieldUserEmailField ;//
    WebElement fieldUserPasswordField ;//
    WebElement buttonSubmit ;//

    public LandingPage(WebDriver driver) {//
        this.driver=driver;
        initElements();
    }
    public void initElements(){
        fieldUserEmailField =driver.findElement(By.xpath("//input[@id='login-email']"));//
        fieldUserPasswordField= driver.findElement(By.xpath("//input[@id='login-password']"));//
        buttonSubmit= driver.findElement(By.xpath("//input[@id='login-submit']"));
    }


    public void login (String userEmail, String userPassword ) {
        fieldUserEmailField.sendKeys(userEmail);
        fieldUserPasswordField.sendKeys(userPassword);
        buttonSubmit.sendKeys(Keys.ENTER);
    }
}
