import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends BaseTest {

    private String searchTerm;
    @DataProvider
    public Object[][] searchInputTest() {
        return new Object[][]{
                {"anonim3225@gmail.com", "Qwerty12", "HR", 20}
        };
    }

    @Test(dataProvider = "searchInputTest")
    public void basicSearchTest(String userEmail, String userPassword, String searchWord,  Integer positiveResultCounter) throws InterruptedException {
        HomePage homePage = landingPage.login(userEmail, userPassword);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        Assert.assertTrue(homePage.isPageLoaded(), "Home Page is not loaded");


        // с преподавателем
        SearchResultPage searchResultPage = homePage.search("HR");
        Assert.assertTrue(searchPage.isPageLoaded(), "Search page is not loaded");
        Assert.assertEquals(searchResultPage.getSearchResultsCount(),10,"Search results count is wrong");

        //создать новый метод с результатом поиска и впихнуть его в список
        List<String> searchResultList = searchResultPage.getSearchResultsList();

        //создать метод verifySearchResults()

        for (String searchResult:searchResultList) {
            Assert.assertTrue(searchResultList.contains(searchTerm), "pls write msg");
        }
        ;


        //

        /* //my decision
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.searchTest(searchWord);
        Assert.assertEquals(searchResultPage.getResults(),positiveResultCounter, "Number of results is wrong or some of them is not contain word you need");
*/
    }


}
