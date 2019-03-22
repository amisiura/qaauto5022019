package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;

import java.util.List;

public class SearchTests extends BaseTest {

   // public String searchTerm ="HR";
    @DataProvider
    public Object[][] searchInputTest() {
        return new Object[][]{
                {"anonim3225@gmail.com", "Qwerty12", "HR"}
        };
    }

    @Test(dataProvider = "searchInputTest")
    public void basicSearchTest(String userEmail, String userPassword, String searchWord) throws InterruptedException {
        HomePage homePage = landingPage.login(userEmail, userPassword);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");
        // с преподавателем
        SearchResultPage searchResultPage = homePage.search(searchWord);
        Assert.assertTrue(searchResultPage.isPageLoaded(), "Search page is not loaded");
        Assert.assertEquals(searchResultPage.getSearchResultsCount(),10,"Search results count is wrong");

        //создать новый метод с результатом поиска и впихнуть его в список
        List<String> searchResultList = searchResultPage.getSearchResultsList();

        for (String searchResult:searchResultList) {
            System.out.println("searchResult is :" + searchResult);
            Assert.assertTrue(searchResult.contains(searchWord), "There is no string "+ "'"+ searchWord +"'" +" in the next string : " + searchResult);
        }
    }
}
