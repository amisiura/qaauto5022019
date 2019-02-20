import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForumFinance {

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

        }
}