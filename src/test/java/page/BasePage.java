package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * abstract class that describes common methods for different pages
 */
public abstract class BasePage {
    protected static String resetPasswordURL;
    protected WebDriver driver;

    /** abstract method that shows isPageLoaded method is mandatory for each page
     * @return no return
     * @throws InterruptedException is exception
     */
    protected abstract boolean isPageLoaded() throws InterruptedException;


    /** method that is stopping action till webelement is visioned
     * @param webElement  that needs to be visioned
     * @param timeOutInSeconds is maximum timeout to see webelemnt
     */
    protected void waitUntilElementIsVisible(WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}


