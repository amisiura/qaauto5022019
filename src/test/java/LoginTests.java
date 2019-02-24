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

    @AfterMethod  // задаем посткондишены
    public void afterMethod() throws InterruptedException  {
        Thread.sleep(1000);
        driver.quit();
    }

    @DataProvider
    public Object[][] validDataPositiveTest() {
        return new Object[][]{
                {"anonim3225@gmail.com", "Qwerty12"}
//              ,{"anoNIM3225@gmail.com", "Qwerty12"}
//                ,{" anonim3225@gmail.com ", "Qwerty12"}
        };
    }

    @Test(dataProvider = "validDataPositiveTest")
    public void successfulLoginTest(String userEmail, String userPassword) {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.login(userEmail, userPassword);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        System.out.println("landingPage.isPageLoaded() is :" + landingPage.isPageLoaded());
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Home Page is not loaded");

    }

    @DataProvider
    public Object[][] validDataNegativeTest() {
        return new Object[][]{
                {"test1", "Qwerty12", "Please enter a valid email address.",""},
                {"anonim3225@gmail.com", "Qwerty123", "","Hmm, that's not the right password. Please try again or request a new one."}
        };
    }

    @Test(dataProvider="validDataNegativeTest")
    public void negativeLoginTestIncorrectEmail(String userEmail, String userPassword, String userNameErrorGetText, String passwordErrorGetText) {// неверный формат емейла id="error-for-username" + .isEnabled()=true
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login(userEmail, userPassword);
        LoginSubmit loginSubmit = new LoginSubmit(driver);
        Assert.assertEquals(loginSubmit.userNameErrorGetText(), userNameErrorGetText, "Email is not valid");
        Assert.assertEquals(loginSubmit.passwordErrorGetText(), passwordErrorGetText, "Password is not valid");
    }
}