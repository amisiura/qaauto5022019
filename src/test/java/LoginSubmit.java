import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmit {

    WebDriver driver;

    WebElement fieldUserEmailField;//
    WebElement fieldUserPasswordField;//
    WebElement buttonSubmit;//
    WebElement userNameError;

    public LoginSubmit(WebDriver driver) {//
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        fieldUserEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));//
        fieldUserPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));//
        buttonSubmit = driver.findElement(By.xpath("//input[@id='login-submit']"));
        userNameError = driver.findElement(By.xpath("//div[@id='error-for-username']"));
    }
    public void login (String userEmail, String userPassword ) {
        fieldUserEmailField.sendKeys(userEmail);
        fieldUserPasswordField.sendKeys(userPassword);
        buttonSubmit.sendKeys(Keys.ENTER);
    }
    public String errorGetText(){
        return
        userNameError.getText();
    }
}

