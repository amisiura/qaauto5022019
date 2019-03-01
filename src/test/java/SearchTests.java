import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @DataProvider
    public Object[][] searchInputTest() {
        return new Object[][]{
                {"anonim3225@gmail.com", "Qwerty12"}
        };
    }

    @Test(dataProvider = "searchInputTest")
    public void basicSearchTest(String userEmail, String userPassword) {

        HomePage homePage = landingPage.login(userEmail, userPassword);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        Assert.assertTrue(homePage.isPageLoaded(), "Home Page is not loaded");
    }


}
