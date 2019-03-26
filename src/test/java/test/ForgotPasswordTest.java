package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class ForgotPasswordTest extends BaseTest {
    String newPassword = "Qwerty13434";
    String link = "https://www.linkedin.com/checkpoint/rp/password-reset?requestSubmissionId=AgFqWvSe5yCpzwAAAWm4jwgvEeuPuQ7Ql5XSPvTvq-xv84RIrEqdL_4NkNqS-70Li0Vrj_l-N-ZfP8R_q1XAOqEEeEajjXLP_2GCkrfrY0k&lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3BdN6Bwe8MTZi9CAGFbicQeg%3D%3D&userName=AgETXrPjTHfjEgAAAWm4jwgq37prLN6YTKIhaRkx6qZGlydJf5P9hUaUYMmAL9Arl9SWAM7M&oneTimeToken=3028483213802947362&trk=eml-jav-saved-job&midToken=AQHofJhdYOOnzA&fromEmail=fromEmail&ut=0x6_nUf7S168I1";

    String userEmail = "anonim3225@gmail.com";

    @Test
    public void successfulPasswordResetTest() throws InterruptedException {

        //1
        ForgotPasswordPage forgotPasswordPage = landingPage.resetPassword();// жмем кнопку "Забыли пароль" и переходим на ForgotPasswordPage
        Assert.assertTrue(forgotPasswordPage.isPageLoaded(), "ForgotPasswordPage is not loaded");
        //2
        ResetPasswordPage resetPasswordPage = forgotPasswordPage.resetPassword(userEmail);// ввожу емейл на который отправится ссылка и нажимаю кнопку
        Assert.assertTrue(resetPasswordPage.isPageLoaded());

        PasswordChangedPage passwordChangedPage = resetPasswordPage.setNewPassword(newPassword, link);// здесь работаю с полученной ссылкой, дважды ввожу новый пароль

        HomePage homePage = passwordChangedPage.backToHomePage();
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");
    }
}
