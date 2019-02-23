import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;

    @BeforeMethod// задаем прекондишены
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\misiura_o\\IdeaProjects\\qaauto5022019\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(); /* объявление переменной (имя - driver, тип - Webdriver) и задание значения - создание нового объекта хром драйвера, new - создание нового объекта */
        driver.get("https://www.linkedin.com/");// переходим на заданную страницу
    }
/*
    @AfterMethod  // задаем посткондишены
    public void afterMethod() {
        driver.quit();
    }
*/

    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                {"anonim3225@gmail.com", "Qwerty12"}
                //              ,{"anoNIM3225@gmail.com", "Qwerty12"}
//                ,{" anonim3225@gmail.com ", "Qwerty12"}
        };
    }

    @Test(dataProvider = "validData")
    public void successfulLoginTest(String userEmail, String userPassword) throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.login(userEmail, userPassword);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        System.out.println("landingPage.isPageLoaded() is :" + landingPage.isPageLoaded());
        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isPageLoaded(), "Home Page is not loaded");
    }


    @Test()
    public void negativeLoginTestIncorrectEmail() {// неверный формат емейла id="error-for-username" + .isEnabled()=true
        LandingPage landingPage= new LandingPage(driver);
        landingPage.login("anonim3225com", "Qwerty12");
        LoginSubmit loginSubmit = new LoginSubmit(driver);
        Assert.assertEquals(loginSubmit.userNameErrorGetText(), "Please enter a valid email address.", "Email is not valid");
    }
    @Test()
    public void negativeLoginTestIncorrectPassword() {// неверный формат емейла id="error-for-username" + .isEnabled()=true
        LandingPage landingPage= new LandingPage(driver);
        landingPage.login("anonim3225@gmail.com", "Qwerty122");
        LoginSubmit loginSubmit = new LoginSubmit(driver);
        Assert.assertEquals(loginSubmit.passwordErrorGetText(), "Hmm, that's not the right password. Please try again or request a new one.",
                "Password is not valid");
    }

}