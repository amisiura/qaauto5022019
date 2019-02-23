import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        @Test
        public void testTtt() {
            WebElement ttt = driver.findElement(By.xpath("//input[@id='login-submit']"));

            if( ttt.isDisplayed() ){
                System.out.print("Это оператор if");
            }else{
                System.out.print("Это оператор else");
            }
        }

        }
