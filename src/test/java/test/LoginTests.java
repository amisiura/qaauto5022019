package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{


    @DataProvider
    public Object[][] validDataPositiveTest() {
        return new Object[][]{
                {"anonim3225@gmail.com", "Qwerty12"}
//              ,{"anoNIM3225@gmail.com", "Qwerty12"}
//              ,{" anonim3225@gmail.com ", "Qwerty12"}
        };
    }

    @Test(dataProvider = "validDataPositiveTest")
    public void successfulLoginTest(String userEmail, String userPassword) {

        HomePage homePage = landingPage.login(userEmail, userPassword);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");
    }

    @DataProvider
    public Object[][] validDataNegativeTest() {
        return new Object[][]{
                {"anonim3225", "Qwerty12", "Please enter a valid email address.",""},
                {"anonim3225@gmail.com", "Qwerty123", "","Hmm, that's not the right password. Please try again or request a new one."}
        };
    }

    @Test(dataProvider="validDataNegativeTest")
    public void negativeLoginTestIncorrectEmail(String userEmail, String userPassword, String userNameErrorGetText, String passwordErrorGetText) {// неверный формат емейла id="error-for-username" + .isEnabled()=true

        LoginSubmit loginSubmit= landingPage.login(userEmail, userPassword);

        Assert.assertTrue(loginSubmit.isPageLoaded(),"page is not loaded");
        Assert.assertEquals(loginSubmit.getUserNameErrorGetText(), userNameErrorGetText, "Email is not valid");
        Assert.assertEquals(loginSubmit.getPasswordErrorGetText(), passwordErrorGetText, "Password is not valid");
    }
}