package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginSubmitPage;

public class LoginTests extends BaseTest{


    @DataProvider
    public Object[][] validDataPositiveTest() {
        return new Object[][]{
                {"a.l.e.x.e.u.s.1979@gmail.com", "QpAlZm=1979"}
//              ,{"a.l.e.X.E.u.s.1979@gmail.com", "QpAlZm=1979"}
//              ,{" a.l.e.x.e.u.s.1979@gmail.com ", "QpAlZm=1979"}
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
                {"a.l.e.x.e.u.s.1979", "QpAlZm=1979", "Please enter a valid email address.",""},
                {"a.l.e.x.e.u.s.1979@gmail.com", "QpAlZm=197", "","Hmm, that's not the right password. Please try again or request a new one."}
        };
    }

    @Test(dataProvider="validDataNegativeTest")
    public void negativeLoginTestIncorrectEmail(String userEmail, String userPassword, String userNameErrorGetText, String passwordErrorGetText) {// неверный формат емейла id="error-for-username" + .isEnabled()=true

        LoginSubmitPage loginSubmitPage= landingPage.login(userEmail, userPassword);

        Assert.assertTrue(loginSubmitPage.isPageLoaded(),"page is not loaded");
        Assert.assertEquals(loginSubmitPage.getUserNameErrorGetText(), userNameErrorGetText, "Email is not valid");
        Assert.assertEquals(loginSubmitPage.getPasswordErrorGetText(), passwordErrorGetText, "Password is not valid");
    }
}