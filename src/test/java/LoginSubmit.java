import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmit {

    WebDriver driver;

    WebElement userNameError;
    WebElement passwordError;

    public LoginSubmit(WebDriver driver) {//
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        userNameError = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        passwordError = driver.findElement(By.xpath("//div[@id='error-for-password']"));
    }


    public String userNameErrorGetText(){
        return
                userNameError.getText();
    }

    public String passwordErrorGetText(){
        return
                passwordError.getText();
    }

}

