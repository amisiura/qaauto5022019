package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ForgotPasswordPage extends BasePage {

    public String linkToResetPassword;
    @FindBy(xpath = "//input[@name=\"userName\"]")
    private WebElement mailResetPassword;

    @FindBy(xpath = "//button[@id=\"reset-password-submit-button\"]")
    private WebElement sendLetterOnMailToResetPassword;


    public ForgotPasswordPage(WebDriver driver) {//
        this.driver = driver;
        PageFactory.initElements(driver, this); // this это класс, в данном случае текущий. Можно было указать page.LandingPage
    }


    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/request-password-reset");
    }

    public ResetPasswordPage  resetPassword(String userEmail) {
        mailResetPassword.sendKeys(userEmail);
        ////
        String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
        String messageTo = userEmail;
        String messageFrom = "security-noreply@linkedin.com";

        GMailService gMailService = new GMailService();
        gMailService.connect();
        sendLetterOnMailToResetPassword.click();

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);
        resetPasswordURL= StringUtils.substringBetween(message, "нажмите ссылку ниже.</p></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;padding-bottom:20px;\"> <p style=\"margin:0;color:#4C4C4C;font-weight:400;font-size:16px;line-height:1.25;\"><a href=\"", "\" style=\"cursor:pointer;color:#008CC9;-webkit-text-size-adjust:100%;display:inline-block;text-decoration:none;-ms-text-size-adjust:100%;\">Изменить пароль</a>").replace("amp;", "");
        System.out.println("Link to reset password is: "+resetPasswordURL);
      /*  ////
        String linkToResetPassword;
        List<String> containedUrls = new ArrayList<String>();
        String urlRegex = "((https?):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(message);
        while (urlMatcher.find())
        {

            containedUrls.add(message.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }
        linkToResetPassword=containedUrls.get(5);
        System.out.println(linkToResetPassword);*/

        ///

        return new ResetPasswordPage(driver);
    }




}