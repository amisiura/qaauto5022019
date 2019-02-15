//import org.openqa.selenium.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_tests {
    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\misiura_o\\IdeaProjects\\qaauto5022019\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(); /* объявление переменной (имя - driver, тип - Webdriver) и задание значения - создание нового объекта хром драйвера, new - создание нового объекта */
        driver.get("https://www.linkedin.com/");// переходим на заданную страницу
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
    @Test
    public void succesfullLoginTest(){

        //Home task 12.02.2019
        String login = "anonim3225@gmail.com" ;
        String pswd = "Qwerty12" ;

        WebElement fieldUserEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));//
        WebElement fieldUserPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));//
        WebElement buttonSubmit = driver.findElement(By.xpath("//input[@id='login-submit']"));//

        fieldUserEmailField.sendKeys(login);
        fieldUserPasswordField.sendKeys(pswd);

        buttonSubmit.sendKeys(Keys.ENTER);

        WebElement prifileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        prifileMenuItem.isDisplayed();
       Assert.assertTrue(prifileMenuItem.isDisplayed(),"prifileMenuItem is displayed on Home Page");
       Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/",
               "Home Page URL is not correct");
}
    @Test
    public void negativeLoginTest (){}
}