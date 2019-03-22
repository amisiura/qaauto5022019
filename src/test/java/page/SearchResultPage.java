package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class SearchResultPage {

    private WebDriver driver;

    private String searchWord;
    public Integer numberFoundResults;
    public Integer positiveResultCounter;

    public SearchResultPage(WebDriver driver) {//
        this.driver = driver;
        PageFactory.initElements(driver, this); // this это класс, в данном случае текущий. Можно было указать page.LandingPage
    }

    JavascriptExecutor js = ((JavascriptExecutor)driver);

    @FindBy(xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement showResults;

    @FindBy(xpath = "//li[contains(@class, 'search-result ')]")
    private List<WebElement> searchResultElements;

    @FindBy(xpath = "//li[contains(@class, 'search-result ')]//h3")
    private List<WebElement> searchResultElementsTexts;


    @FindBy(xpath = "//div[@class=\"nav-search-typeahead\"]")
    private WebElement fieldInputSearch;//

    public boolean isPageLoaded() throws InterruptedException{
        Thread.sleep(5000);
        return
                showResults.isDisplayed() &&
                        driver.getCurrentUrl().contains("/search/results/") &&
                        driver.getTitle().contains("LinkedIn");
    }



    public List<String> getSearchResultsList() throws InterruptedException{
        Thread.sleep(1000);
        //js.executeScript("window.scrollBy(0,2500)");
        Thread.sleep(1000);
        List<String> searchListResultTexts = new ArrayList<String>();
        //driver.manage().window().maximize();
        for (WebElement searchResultElementsText : searchResultElementsTexts) {
           // ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", searchResultElementsText);
            searchListResultTexts.add(searchResultElementsText.getText());
        }
        return searchListResultTexts;
    }

    public int getSearchResultsCount() {
        return searchResultElements.size();
    }
}



