package ChangePasswordPO;

import ChangePINPO.ChangePIN;
import CommonPO.BasePage;
import LoginPO.Login;
import LoginPO.LoginConstant;
import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/**
 * @author Vidhi Chapanera
 * @date 28 October 2021
 */
public class ChangePassword extends BasePage {

    public WebDriver driver;

    public static String newPasswordLine = "Asd-45";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for current user
     * @date 28 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//img[@id='HeaderProfilePicture']//parent::a"
    )
    WebElement currentUser;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for change password button
     * @date 28 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[normalize-space(.)='Change password']"
    )
    WebElement btn_changePassword;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for current password field
     * @date 28 October 2021
     */
    @FindBy(
            how = How.NAME,
            using = "CurrentPassword"
    )
    WebElement txt_currentPassword;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for new password field
     * @date 28 October 2021
     */
    @FindBy(
            how = How.NAME,
            using = "NewPassword"
    )
    WebElement txt_newPassword;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for new password repeat field
     * @date 28 October 2021
     */
    @FindBy(
            how = How.NAME,
            using = "NewPasswordRepeat"
    )
    WebElement txt_newPasswordRepeat;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for logout button
     * @date 28 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Logout')]"
    )
    WebElement btn_logout;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for login failed popup
     * @date 28 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[text()='The email or password you entered is incorrect']"
    )
    WebElement alert_failedPopup;


    public ChangePassword(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getCurrentUser() {
        return currentUser;
    }
    public WebElement getChangePasswordButton() {
        return btn_changePassword;
    }
    public WebElement getCurrentPassword() {
        return txt_currentPassword;
    }
    public WebElement getNewPassword() {
        return txt_newPassword;
    }
    public WebElement getNewPasswordRepeat() {
        return txt_newPasswordRepeat;
    }
    public WebElement getLogoutButton() {
        return btn_logout;
    }
    public WebElement getFailedAlertPopup() {
        return alert_failedPopup;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 28 October 2021
     * @discription this method is use to Change Current PIN
     */
    @Step("Change Current PIN")
    public boolean changeOldPassword() throws IOException {
        String fileLocation = System.getProperty("user.dir") + "\\src\\main\\resources\\loginDetails.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));
        try {
            sleepFor(3);
            getCurrentPassword().sendKeys(properties1.getProperty("password_1"));
            getNewPassword().sendKeys(newPasswordLine);
            getNewPasswordRepeat().sendKeys(newPasswordLine);
            PageFactory.initElements(driver, ChangePIN.class).getSaveButton().click();
            sleepFor(5);
            getCurrentUser().click();
            getLogoutButton().click();
            sleepFor(5);
            return true;
        } catch (StaleElementReferenceException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 28 October 2021
     * @discription this method is use to Verify New Password is updated by using login again
     */
    @Step("Verify New Password is updated by using login again")
    public boolean VerifyNewPassword() throws IOException {
        sleepFor(5);
        String fileLocation = System.getProperty("user.dir") + "\\src\\main\\resources\\loginDetails.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));
        Login login = PageFactory.initElements(driver, Login.class);
        try {
            sleepFor(3);
            login.getEmailTextBox().sendKeys(String.valueOf(properties1.put(LoginConstant.EMAIL_ADDRESS,"email_address")));
            login.getpasswordTextBox().sendKeys(newPasswordLine);
            login.getLoginButton().click();
            sleepFor(5);
            try
            {
                getFailedAlertPopup().isDisplayed();
                return false;
            }catch (Exception e)
            {
                PageFactory.initElements(driver, ChangePIN.class).getCurrentUser().click();
                getChangePasswordButton().click();
                sleepFor(3);
                getCurrentPassword().sendKeys(newPasswordLine);
                getNewPassword().sendKeys(properties1.getProperty("password_1"));
                getNewPasswordRepeat().sendKeys(properties1.getProperty("password_1"));
                sleepFor(3);
                PageFactory.initElements(driver, ChangePIN.class).getSaveButton().click();
                sleepFor(10);
                return true;
            }
        } catch (StaleElementReferenceException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    
}