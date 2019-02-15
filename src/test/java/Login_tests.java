//import org.openqa.selenium.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login_tests {
    @Test
    public void succesfullLoginTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\misiura_o\\IdeaProjects\\qaauto5022019\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); /* объявление переменной (имя - driver, тип - Webdriver) и задание значения - создание нового объекта хром драйвера, new - создание нового объекта */
        driver.get("https://www.linkedin.com/");// переходим на заданную страницу
        //Home task 12.02.2019
        String login = "anonim3225@gmail.com" ;
        String pswd = "Qwerty12" ;

        WebElement fieldLogin = driver.findElement(By.name("/session_key"));//
        WebElement fieldPassword = driver.findElement(By.name("session_password"));//

        fieldLogin.sendKeys(login);
        fieldPassword.sendKeys(pswd);

        WebElement buttonSubmit = driver.findElement(By.id("login-submit"));//
        buttonSubmit.sendKeys(Keys.ENTER);
        //searchButton.click(); //альтернативный путь нажатия на кнопку

        boolean ifExist;
        try {
            driver.findElement(By.xpath("//span[@class='t-16 t-black t-bold']"));
            ifExist = true;
        } catch (NoSuchElementException e) {
            ifExist = false;
        }

        if (ifExist)
        {
            System.out.println("Login is succesfull");
        }
        else
        {
            System.out.println("Login is not successfull");
        }
}
}