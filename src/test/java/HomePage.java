import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath ="//div@[class=\"nav-search-typeahead\"]")
    private WebElement searchField;

    @FindBy(xpath ="//form@[@id='extended-nav-search']")
    private WebElement profileMenuItem;

    public HomePage(WebDriver driver) {
        this.driver = driver;
       // PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded() {
        return
               // profileMenuItem.isDisplayed()&&
                         driver.getCurrentUrl().contains("/feed")
                        && driver.getTitle().contains("LinkedIn");
    }

    //создаем новый метод для поиска HR, получаем переход на новую страницу с результатами поиска и создаем ретурном новый объект для этой страницы
    public SearchResultPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);

    }
}












