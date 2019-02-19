//import org.openqa.selenium.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_tests {
    WebDriver driver;

    @BeforeMethod// задаем прекондишены
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\misiura_o\\IdeaProjects\\qaauto5022019\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(); /* объявление переменной (имя - driver, тип - Webdriver) и задание значения - создание нового объекта хром драйвера, new - создание нового объекта */
        driver.get("https://www.linkedin.com/");// переходим на заданную страницу
    }

    @AfterMethod  // задаем посткондишены
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void succesfullLoginTest() {

        //Home task 12.02.2019

        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("anonim3225@gmail.com", "Qwerty12");

      //  WebElement profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        HomePage homePage = new HomePage(driver);
        homePage.meIcon();
        //profileMenuItem.isDisplayed();
        Assert.assertTrue(homePage.meIcon(), "profileMenuItem is displayed on Home Page");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/",
                "Home Page URL is not correct");
    }

    //////////////////////////////


    @Test()
    public void negativeLoginTestIncorrectEmail() {// неверный формат емейла id="error-for-username" + .isEnabled()=true
        LoginSubmit loginSubmit = new LoginSubmit(driver);
        loginSubmit.login("anonim3225com", "Qwerty12");


        WebElement userNameError = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        Assert.assertEquals(userNameError.getText(), "Please enter a valid email address.","Email is not valid");
    }

    @Test()
    public void negativeLoginTestNotExistedEmail() {

        WebElement fieldUserEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));//
        WebElement fieldUserPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));//
        WebElement buttonSubmit = driver.findElement(By.xpath("//input[@id='login-submit']"));//
        String login;
        String pswd;

        // незарегистрированный емейл id="error-for-username" + .isEnabled()=true
        login = "anonim3225@gmaiil.com";
        pswd = "Qwerty12";

        fieldUserEmailField.sendKeys(login);
        fieldUserPasswordField.sendKeys(pswd);
        buttonSubmit.sendKeys(Keys.ENTER);
        WebElement userNameError = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        Assert.assertEquals(userNameError.getText(), "We don't recognize that email.\n" +
                "Did you mean: @gmail.com?");
    }

    @Test()
    public void negativeLoginTestIsButtonDisabled() {
        // не заполнены поля логина и пароля, кнопка не активна .isEnabled()=false;
        WebElement buttonSubmit = driver.findElement(By.xpath("//input[@id='login-submit']"));//
        Assert.assertFalse(buttonSubmit.isEnabled(), "The button Submit is enabled");

        // неверный емейл id="error-for-username" + .isEnabled()=true
        // неверный пароль  id="error-for-password" + .isEnabled()=true
    }

}