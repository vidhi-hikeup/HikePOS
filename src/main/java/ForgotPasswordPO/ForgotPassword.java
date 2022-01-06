package ForgotPasswordPO;

import ChangePasswordPO.ChangePassword;
import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import InventoryPO.PurchasesPO.Purchases;
import LoginPO.Login;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
import ProductsPO.GiftCardsPO.GiftCards;
import UsersPO.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.mail.*;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vidhi Chapanera
 * @date 30 December 2021
 */
public class ForgotPassword extends BasePage {

    public WebDriver driver;
    public static String testName = "Vidhi Bakaraniya";
    public static String testEmail = "vidhi.hike.99@gmail.com";
    public static String receivingBodyPart = "";
    public static String receivingSubject = "";
    public static String testNewPassword = "@Test4196";

    /**
     *
     * @author Vidhi Chapanera
     * @discription this locator is for FORGOT link
     * @date 30 December 2021
     */
    @FindBy(
            how = How.LINK_TEXT,
            using = "Forgot?"
    )
    WebElement btn_forgot;

    /**
     *
     * @author Vidhi Chapanera
     * @discription this locator is for email address
     * @date 30 December 2021
     */
    @FindBy(
            how = How.ID,
            using = "emailAddress"
    )
    WebElement emailAddress;

    /**
     *
     * @author Vidhi Chapanera
     * @discription this locator is for send email button
     * @date 30 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Send email']"
    )
    WebElement sendEmailButton;

    /**
     *
     * @author Vidhi Chapanera
     * @discription this locator is for send email button
     * @date 30 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[text()='Password reset link sent to your email address. Please check your inbox.']"
    )
    WebElement sucessMessage;

    /**
     *
     * @author Vidhi Chapanera
     * @discription this locator is for Password
     * @date 30 December 2021
     */
    @FindBy(
            how = How.NAME,
            using = "Password"
    )
    WebElement password;

    /**
     *
     * @author Vidhi Chapanera
     * @discription this locator is for Password repeat
     * @date 30 December 2021
     */
    @FindBy(
            how = How.NAME,
            using = "PasswordRepeat"
    )
    WebElement passwordRepeat;

    /**
     *
     * @author Vidhi Chapanera
     * @discription this locator is for submit button
     * @date 30 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Submit']"
    )
    WebElement submitButton;



    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getForgot() {
        return btn_forgot;
    }
    public WebElement getEmailAddress() {
        return emailAddress;
    }
    public WebElement getSendEmailButton() {
        return sendEmailButton;
    }
    public WebElement getSucessMessage() {
        return sucessMessage;
    }
    public WebElement getPassword() {
        return password;
    }
    public WebElement getPasswordRepeat() {
        return passwordRepeat;
    }
    public WebElement getSubmitButton() {
        return submitButton;
    }



    /**
     * @author Vidhi Chapanera
     * @date 30 December 2021
     * @return
     * @throws Exception
     * @discription this method is used to Add User
     */
    @Step("Add User")
    public boolean addUser() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(15);
            PageFactory.initElements(driver, Users.class).clickOnUsersButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getUsersButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getAddUsersButton());
            sleepFor(3);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getName(),testName.split(" ")[0]);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getSurname(),testName.split(" ")[1]);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getEmailAddress(),testEmail);
            sleepFor(1);
            WebElement rbtn = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='EditUser_Manager']")));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", rbtn);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getSetRandomPasswordCheckbox());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getUserName(),"V1");
            centerlizePO.clearText(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getUserPin());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getUserPin(),"4100");
            centerlizePO.clickOnButton(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getAllOutletCheckBox());
            centerlizePO.clickOnButton(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, ChangePassword.class).getCurrentUser().click();
            sleepFor(2);
            PageFactory.initElements(driver,ChangePassword.class).getLogoutButton().click();
            sleepFor(10);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 30 December 2021
     * @return
     * @param message
     * @throws Exception
     */
    @Step("message : {0}")
    private String getTextFromMessage(Message message) throws IOException, MessagingException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }


    /**
     * @author Vidhi Chapanera
     * @date 30 December 2021
     * @return
     * @param mimeMultipart
     * @throws Exception
     */
    @Step("mimeMultipart : {0}")
    private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws IOException, MessagingException {
        int count = mimeMultipart.getCount();
        if (count == 0)
            throw new MessagingException("Multipart with no body parts not supported.");
        boolean multipartAlt = new ContentType(mimeMultipart.getContentType()).match("multipart/alternative");
        if (multipartAlt)
            return getTextFromBodyPart(mimeMultipart.getBodyPart(count - 1));
        String result = "";
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            result += getTextFromBodyPart(bodyPart);
        }
        return result;
    }


    /**
     * @author Vidhi Chapanera
     * @date 30 December 2021
     * @return
     * @param bodyPart
     * @throws Exception
     */
    @Step("bodyPart : {0}")
    private String getTextFromBodyPart(BodyPart bodyPart) throws IOException, MessagingException {
        String result = "";
        if (bodyPart.isMimeType("text/plain")) {
            result = (String) bodyPart.getContent();
        } else if (bodyPart.isMimeType("text/html")) {
            String html = (String) bodyPart.getContent();
            result = org.jsoup.Jsoup.parse(html).text();
        } else if (bodyPart.getContent() instanceof MimeMultipart){
            result = getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
        }
        return result;
    }


    /**
     * @author Vidhi Chapanera
     * @date 30 December 2021
     * @return
     * @throws Exception
     */
    public boolean readEmail() {
        String receivingHost="imap.gmail.com";
        Properties props2=System.getProperties();
        Session session2=Session.getDefaultInstance(props2, null);
        try {
            Store store=session2.getStore("imaps");
            String userName = "vidhi.hike.99@gmail.com";
            store.connect(receivingHost,userName, "#Test4196");
            Folder folder=store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            Message message[]=folder.getMessages();
            String receivingSubject = message[message.length-1].getSubject();
            System.out.println("receivingSubject : " + receivingSubject);
            receivingBodyPart = org.jsoup.Jsoup.parse(message[message.length-1].getContent().toString()).text();
            System.out.println(receivingBodyPart);
            folder.close(true);
            store.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     *
     * @author Vidhi Chapanera
     * @date 30 December 2021
     * @return
     * @throws Exception
     */
    public String getExtractURL() {
        String testURL = "";
        List<String> list= new ArrayList<>();
        String regex
                = "\\b((?:https?|ftp|file):"
                + "//[-a-zA-Z0-9+&@#/%?="
                + "~_|!:, .;]*[-a-zA-Z0-9+"
                + "&@#/%=~_|])";
        Pattern p = Pattern.compile(
                regex,
                Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(receivingBodyPart);
        while (m.find()) {
            list.add(receivingBodyPart.substring(
                    m.start(0), m.end(0)));
        }
        if (list.size() == 0) {
            System.out.println("-1");
        }
        for (String url : list) {
            System.out.println(url);
            testURL =url;
        }

        return testURL;
    }


    /**
     * @author Vidhi Chapanera
     * @date 30 December 2021
     * @return
     * @throws Exception
     */
    public boolean resetPassword() {
        try {
            readEmail();
            ((JavascriptExecutor) driver).executeScript("window.open();");
            sleepFor(3);
            ArrayList<String> allWindows = new ArrayList<String> (driver.getWindowHandles());
            System.out.println(allWindows.size());
            driver.switchTo().window(allWindows.get(allWindows.size()-1));
            sleepFor(2);
            driver.get(getExtractURL());
            sleepFor(10);
            driver.switchTo().window(allWindows.get(0));
            driver.close();
            driver.switchTo().window(allWindows.get(allWindows.size()-1));
            PageFactory.initElements(driver,CenterlizePO.class).enterDataUsingSendkeys(getPassword(),testNewPassword);
            PageFactory.initElements(driver,CenterlizePO.class).enterDataUsingSendkeys(getPasswordRepeat(),testNewPassword);
            PageFactory.initElements(driver,CenterlizePO.class).clickOnButton(getSubmitButton());
            sleepFor(10);
            PageFactory.initElements(driver, ChangePassword.class).getCurrentUser().click();
            sleepFor(2);
            PageFactory.initElements(driver,ChangePassword.class).getLogoutButton().click();
            sleepFor(10);
            PageFactory.initElements(driver, Login.class).getEmailTextBox().sendKeys(testEmail);
            sleepFor(1);
            PageFactory.initElements(driver, Login.class).getpasswordTextBox().sendKeys(testNewPassword);
            sleepFor(1);
            PageFactory.initElements(driver, Login.class).getLoginButton().click();
            sleepFor(15);
            Assert.assertTrue(PageFactory.initElements(driver, ChangePassword.class).getCurrentUser().isDisplayed());
            return true;
        } catch (Exception e) {
            return false;
        }
    }




}