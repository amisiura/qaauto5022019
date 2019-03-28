package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class ForgotPasswordTest extends BaseTest {
    String newPassword = "Qwerty123123";


    String userEmail = "a.l.e.x.e.u.s.1979@gmail.com";

    @Test
    public void successfulPasswordResetTest() throws InterruptedException {

        //1
        ForgotPasswordPage forgotPasswordPage = landingPage.resetPassword();// жмем кнопку "Забыли пароль" и переходим на ForgotPasswordPage
        Assert.assertTrue(forgotPasswordPage.isPageLoaded(), "ForgotPasswordPage is not loaded");
        //2
        ResetPasswordPage resetPasswordPage = forgotPasswordPage.resetPassword(userEmail);// ввожу емейл на который отправится ссылка и нажимаю кнопку
        Assert.assertTrue(resetPasswordPage.isPageLoaded());

        PasswordChangedPage passwordChangedPage = resetPasswordPage.setNewPassword(newPassword);// здесь работаю с полученной ссылкой, дважды ввожу новый пароль

        HomePage homePage = passwordChangedPage.backToHomePage();
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");
    }
}
