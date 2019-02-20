//import org.openqa.selenium.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
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
    public void successfulLoginTest() {


        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("anonim3225@gmail.com", "Qwerty12");

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isIconExist(), "profileMenuItem is displayed on Home Page");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home Page URL is not correct");
    }


    @Test()
    public void negativeLoginTestIncorrectEmail() {// неверный формат емейла id="error-for-username" + .isEnabled()=true
        LoginSubmit loginSubmit = new LoginSubmit(driver);
        loginSubmit.login("anonim3225com", "Qwerty12");
        Assert.assertEquals(loginSubmit.errorGetText(), "Please enter a valid email address.", "Email is not valid");
    }

    @Test()
    public void negativeLoginTestNotExistedEmail() {
        LoginSubmit loginSubmit = new LoginSubmit(driver);
        loginSubmit.login("anonim3225@gmaiil.com", "Qwerty12");
        Assert.assertEquals(loginSubmit.errorGetText(), "We don't recognize that email. Did you mean: @gmail.com?");
    }
}