import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class SearchResultPage {

    private WebDriver driver;
    private String searchWord;
    public Integer numberFoundResults;
    public Integer positiveResultCounter;

    public SearchResultPage(WebDriver driver) {//
        this.driver = driver;
        PageFactory.initElements(driver, this); // this это класс, в данном случае текущий. Можно было указать LandingPage
    }

    @FindBy(xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement showResults;

    @FindBy(xpath = "//input[@role=\"combobox\"]")
    private WebElement fieldInputSearch;//

    public boolean isPageLoaded() { //прописать критерии загрузки
        return
                   showResults.isDisplayed()&&
                driver.getCurrentUrl().contains("/search/results/")&&
                driver.getTitle().contains("LinkedIn");
    }

    public void searchTest (String searchWord) throws InterruptedException {// полиморфизм
        fieldInputSearch.sendKeys(searchWord);
        fieldInputSearch.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        List<WebElement> searchResultElements = driver.findElements(By.xpath("//li[@class=\"search-result search-result__occluded-item ember-view\"]"));
        numberFoundResults=searchResultElements.size();
        positiveResultCounter =0;


        /* задаю цикл по списку результатов поиска searchResultElement*/
        for (WebElement searchResultElement : searchResultElements) {
            String searchResultElementText = searchResultElement.getText();/* задаю переменную, куда сохраняю текущий, полученный поиском, текст*/

            if (searchResultElementText.contains(searchWord))
            {
                positiveResultCounter++;
            }
        }
    }

    public Integer getResults(){
        return  positiveResultCounter+numberFoundResults;
        }
    }



